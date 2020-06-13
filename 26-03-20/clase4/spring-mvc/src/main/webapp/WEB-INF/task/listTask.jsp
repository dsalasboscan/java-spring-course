<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<table class="table table-striped">
    <thead class="thead-dark">
    <tr>
        <th style="width: 33.33%">TODO</th>
        <th style="width: 33.33%">In Progress</th>
        <th style="width: 33.33%">Done</th>
    </tr>
    </thead>

    <tbody>
    <tr>
        <td>
            <c:forEach var="task" items="${tasks.TO_DO}">
                <form:form method="POST" action="/task/transition" modelAttribute="task">
                    <div class="row">
                        <div class="col-sm-6">
                            <div class="card">
                                <div class="card-body">
                                    <h4 class="card-title">${task.title}</h4>
                                    <input:hidden value="${task.title}" path="title"/>

                                    <label>Description</label>
                                    <p class="card-text">${task.description}</p>
                                    <input:hidden value="${task.description}" path="description"/>

                                    <label>Due Date</label>
                                    <p class="card-text">${task.dueDate}</p>
                                    <input:hidden value="${task.dueDate}" path="dueDate"/>

                                    <input:hidden value="${task.status}" path="status"/>
                                    <input:hidden value="${task.id}" path="id"/>
                                </div>
                                <div class="card-body">
                                    <button class="btn btn-dark btn-sm" type="submit" name="transitionStatus" value="IN_PROGRESS">PROMOTE</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </form:form>
            </c:forEach>
        </td>

        <td>
            <c:forEach var="task" items="${tasks.IN_PROGRESS}">
                <form:form action="/task/transition" method="POST" modelAttribute="task">
                    <div class="row">
                        <div class="col-sm-6">
                            <div class="card">
                                <div class="card-body">
                                    <h4 class="card-title">${task.title}</h4>
                                    <input:hidden value="${task.title}" path="title"/>

                                    <label>Description</label>
                                    <p class="card-text">${task.description}</p>
                                    <input:hidden value="${task.description}" path="description"/>

                                    <label>Due Date</label>
                                    <p class="card-text">${task.dueDate}</p>
                                    <input:hidden value="${task.dueDate}" path="dueDate"/>

                                    <input:hidden value="${task.status}" path="status"/>
                                    <input:hidden value="${task.id}" path="id"/>
                                </div>
                                <div class="card-footer">
                                    <button class="btn btn-dark btn-sm" type="submit" name="transitionStatus" value="TO_DO">DEMOTE</button>
                                    <button class="btn btn-dark btn-sm" type="submit" name="transitionStatus" value="DONE">PROMOTE</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </form:form>
            </c:forEach>
        </td>

        <td>
            <c:forEach var="task" items="${tasks.DONE}">
                <form:form method="POST" action="/task/transition" modelAttribute="task">
                    <div class="row">
                        <div class="col-sm-6">
                            <div class="card">
                                <div class="card-body">
                                    <h4 class="card-title">${task.title}</h4>
                                    <input:hidden value="${task.title}" path="title"/>

                                    <label>Description</label>
                                    <p class="card-text">${task.description}</p>
                                    <input:hidden value="${task.description}" path="description"/>

                                    <label>Due Date</label>
                                    <p class="card-text">${task.dueDate}</p>
                                    <input:hidden value="${task.dueDate}" path="dueDate"/>

                                    <input:hidden value="${task.status}" path="status"/>
                                    <input:hidden value="${task.id}" path="id"/>
                                </div>
                                <div class="card-footer">
                                    <button class="btn btn-dark btn-sm" type="submit" name="transitionStatus" value="IN_PROGRESS">DEMOTE</button>
                                    <button class="btn btn-dark btn-sm" type="submit" name="transitionStatus" value="CLOSE">CLOSE</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </form:form>
            </c:forEach>
        </td>
    </tr>
    </tbody>
</table>