<#macro logout>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button class="btn btn-primary" type="submit"><#if user??>Выйти<#else>Войти</#if></button>
    </form>
</#macro>