<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>
    <h5><img src="images/user${user.id}" height="30px"> ${user.name} (администратор)</h5>

    <h3>СПИСОК СЧЕТОВ</h3>
    <hr>
    <div class="row">
        <div class=col-md-2>№ счета</div>
        <div class=col-md-2>Остаток средств</div>
        <div class=col-md-1>Валюта</div>
        <div class=col-md-1>ID клиента</div>

        <div class=col-md-2>Запрос на разблокировку</div>
        <div class=col-md-2>Статус</div>
    </div>
    <c:forEach items="${accounts}" var="account">
        <form class="form-horizontal-${account.id}" action="do?command=EditAcc" method="post">
            <div class="row">
                <input id="id" name="id" type="hidden" placeholder="" class="form-control input-md"
                       required="" value="${account.id}">

                <div class="col-md-2">
                    <input id="number" name="number" type="text" placeholder="" class="form-control input-md"
                           required="" value="${account.number}">
                </div>

                <c:forEach items="${balances}" var="entry">
                    <c:if test="${entry.key==account.id}">
                        <div class="col-md-2">
                            <input id="amount" name="amount" type="text" placeholder=""
                            class="form-control input-md" required="" value="${entry.value}">
                        </div>
                    </c:if>
                </c:forEach>

                <div class="col-md-1">
                    <input id="currency" name="currency" type="text" placeholder="" class="form-control input-md"
                           required="" value="${account.currency}">
                </div>

                <div class="col-md-1">
                    <input id="users_id" name="users_id" type="text" placeholder="" class="form-control input-md"
                           required="" value="${account.users_id}">
                </div>

                <div class="col-md-2">
                    <c:choose>
                        <c:when test="${account.unlock_request==1}">
                            <input id="unlock_request" name="unlock_request" type="text" placeholder="" class="form-control input-md"
                            required="" value=" >>разблокировать<< ">
                        </c:when>
                        <c:otherwise>
                            <input id="unlock_request" name="unlock_request" type="text" placeholder="" class="form-control input-md"
                            required="" value="no">
                        </c:otherwise>
                    </c:choose>
                </div>

                <div class="col-md-2">
                    <select id="account_status_id" name="account_status_id" class="form-control">
                        <c:forEach items="${accstatuses}" var="status">
                        <option value="${status.id}"
                        ${account.account_status_id==status.id?"selected":""}>${status.status}</option>
                        </c:forEach>
                    </select>
                </div>

                <!-- Button -->
                <div class="col-md-2">
                    <button id="update" name="update" class="btn btn-success">Обновить статус</button>
                </div>
            </div>
        </form>
    </c:forEach>

    <hr>
    <div class="row">
        <label class="col-md-10 control-label" for="account">${message}</label>
    </div>

    <mytag:paginator count="${accCount}" step="5" urlprefix="do?command=EditAcc&start="/>
    <p> </p>

    <form class="form-horizontal" action="do?command=Profile" method="post">
        <fieldset>
            <!-- Button -->
            <div class="row">
                <div class="col-md-4">
                     <button id="profileButton" name="profileButton" class="btn btn-info">Вернуться в ЛИЧНЫЙ КАБИНЕТ</button>
                </div>
            </div>
        </fieldset>
    </form>

</div>
</body>
</html>