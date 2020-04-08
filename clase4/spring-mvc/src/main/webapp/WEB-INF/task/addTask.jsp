<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">

    <form:form action="/task/add" method="post" modelAttribute="task">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Add task</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">

                    <div class="px-2">
                        <div class="form-group">
                            <label>Title</label>
                            <form:input path="title" class="form-control"/>
                        </div>
                        <div class="form-group">
                            <label>Description</label>
                            <form:input path="description" class="form-control"/>
                        </div>
                        <div class="form-group">
                            <label>Due Date</label>
                            <div class='input-group date' id="datetimepicker1">
                                <form:input path="dueDate" class="form-control"/>
                                <span class="input-group-addon">
                                <span class="glyphicon glyphicon-calendar"></span>
                            </span>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Save changes</button>
                </div>
            </div>
        </div>
    </form:form>
</div>