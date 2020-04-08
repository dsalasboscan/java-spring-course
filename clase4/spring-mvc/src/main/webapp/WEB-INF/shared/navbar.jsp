<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">Task Organization App</a>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" data-toggle="modal" data-target="#exampleModal">Add Task</a>
            </li>
        </ul>
    </div>
</nav>

<!-- Modal -->
<jsp:include page="../task/addTask.jsp"/>