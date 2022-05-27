<#import "login.ftlh" as l>

<nav class="navbar navbar-expand-lg bg-dark">
    <div class="container-fluid">
            <ul class="navbar-nav">
                <li class="nav-brand">
                    <a class="navbar-brand" href="/" style="color: white">Главная</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/shop" style="color: white">Остатки</a>
                </li>
            </ul>
    </div>
    <div class="navbar-text mr-3"><#if user??>${name}</#if></div>
    <@l.logout />
</nav>