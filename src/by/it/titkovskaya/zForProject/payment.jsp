<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>
    <c:choose>
        <c:when test="${user.roles_id==1}">
            <h5>${user.name} (администратор)</h5>
        </c:when>
        <c:otherwise>
            <h5>${user.name}</h5>
        </c:otherwise>
    </c:choose>

    <h3>ПЛАТЕЖ / ДЕНЕЖНЫЙ ПЕРЕВОД</h3>

    <form class="form-horizontal-${account.id}">
        <div class="row">
            <div class="col-md-3">Введите сумму платежа (перевода) в ${account.currency},
            которая будет переведена с Вашего счета № ${account.number}</div>
            <div class="col-md-3">Введите данные получателя</div>
        </div>
    </form>

    <form class="form-horizontal-${account.id}" action="do?command=Payment" method="post">

        <div class="row">
            <input id="id" name="id" type="hidden" placeholder="" class="form-control input-md"
                   required="" value="${account.id}">
            <div class="col-md-3">
                <input id="amount" name="amount" value="10000" type="text" placeholder=""
                class="form-control input-md" required="">
            </div>

            <div class="col-md-3">
                <input id="recipient" name="recipient" value="Test Recipient" type="text" placeholder=""
                class="form-control input-md" required="">
            </div>

            <!-- Button -->
            <div class="col-md-6">
                 <button id="confirmTransfeButton" name="confirmTransfeButton" class="btn btn-success">Подтвердить ДЕНЕЖНЫЙ ПЕРЕВОД</button>
            </div>
        </div>
    </form>

    <div class="row">
        <label class="col-md-6 control-label" for="account">${message}</label>
    </div>

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


