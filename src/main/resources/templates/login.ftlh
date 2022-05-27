<#import "parts/common.ftlh" as c>

<@c.page>
    <div class="row h-100 justify-content-center align-items-center">
        <div class="row justify-content-center">
            <form class="was-validated" action="" method="post">
                <!-- Input fields -->
                <div class="form-group">
                    <h3>Вход в систему</h3>
                    <small style="color: gray">Введите логин</small>
                    <br>
                    <input class="form-control" type="text" name="username" required/>
                    <br>
                    <small style="color: gray">Введите пароль</small>
                    <br>
                    <input class="form-control" type="password" name="password" required/>
                    <br>
                    <button type="submit" class="btn btn-primary btn-customized btn-block">Войти</button>
                </div>
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                <!-- End input fields -->
            </form>
            <!-- Form end -->
        </div>
    </div>
</@c.page>