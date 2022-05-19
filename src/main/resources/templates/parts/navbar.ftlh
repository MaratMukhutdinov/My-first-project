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
    <form class="form-inline" action="/logout" method="post">
        <button class="btn btn-outline-light my-2 my-sm-0" type="submit">Выйти</button>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    </form>
</nav>