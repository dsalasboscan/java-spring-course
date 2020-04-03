package com.eduit.springbootdata.config;

import com.eduit.springbootdata.model.Categoria;
import com.eduit.springbootdata.model.Producto;
import com.eduit.springbootdata.model.dto.ProductoDto;
import com.eduit.springbootdata.repository.CategoriaRepository;
import com.eduit.springbootdata.repository.ProductoRepository;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.data.builder.RepositoryItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.validation.BindException;

@Configuration
public class BatchConfiguration {

    private JobBuilderFactory jobBuilderFactory;
    private StepBuilderFactory stepBuilderFactory;

    public BatchConfiguration(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory) {
        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;
    }

    @Bean
    public Job job(Step step) {
        return jobBuilderFactory.get("job")
                .start(step)
                .build();
    }

    @Bean
    public Step step(ItemReader<ProductoDto> itemReader, ItemProcessor<ProductoDto, Producto> itemProcessor, ItemWriter<Producto> itemWriter) {
        return stepBuilderFactory.get("step1")
                .<ProductoDto, Producto>chunk(10)
                .reader(itemReader)
                .processor(itemProcessor)
                .writer(itemWriter)
                .build();
    }

    @Bean
    public FlatFileItemReader<ProductoDto> productoDtoFlatFileItemReader(FieldSetMapper<ProductoDto> fieldSetMapper) {
        return new FlatFileItemReaderBuilder<ProductoDto>()
                .fieldSetMapper(fieldSetMapper)
                .name("customReader")
                .delimited()
                .names("nombre", "precio", "categoria_id")
                .targetType(ProductoDto.class)
                .resource(new ClassPathResource("productos.csv"))
                .build();
    }

    @Bean
    public FieldSetMapper<ProductoDto> productoDtoFieldSetMapper() {
        return new FieldSetMapper<ProductoDto>() {
            @Override
            public ProductoDto mapFieldSet(FieldSet fieldSet) throws BindException {
                return new ProductoDto(
                        fieldSet.readString("nombre"),
                        fieldSet.readDouble("precio"),
                        fieldSet.readLong("categoria_id")
                );
            }
        };
    }

    @Bean
    public ItemProcessor<ProductoDto, Producto> productoDtoProductoItemProcessor(CategoriaRepository categoriaRepository) {
        return new ItemProcessor<ProductoDto, Producto>() {
            @Override
            public Producto process(ProductoDto productoDto) throws Exception {
                Categoria categoria = categoriaRepository.findById(productoDto.getCategoriaId()).get();
                return new Producto(
                        productoDto.getNombre(),
                        productoDto.getPrecio(),
                        categoria
                );
            }
        };
    }

    @Bean
    public RepositoryItemWriter<Producto> productoRepositoryItemWriter(ProductoRepository productoRepository) {
        return new RepositoryItemWriterBuilder<Producto>()
                .repository(productoRepository)
                .methodName("save")
                .build();
    }
}
