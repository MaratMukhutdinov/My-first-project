<#import "parts/common.ftlh" as c>

<@c.page>
    <table class="table table-hover">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Наименование</th>
            <th scope="col">Количество в мг.</th>
        </tr>
        </thead>
        <tbody>
        <#list coffeeList as coffee>
            <tr>
                <td>${coffee_index + 1}</td>
                <td>${coffee.name}</td>
                <td>${coffee.balance}</td>
            </tr>
        </#list>
        </tbody>
    </table>
    <form method="post">
        <div class="input-group">
            <select class="form-select col-3 mb-3 mr-3" name="coffeeId">
                <#list coffeeList as coffee>
                    <option value=${coffee.id}>${coffee.name}</option>
                </#list>
            </select>
            <input class="form-control col-2 mb-3" type="text" placeholder="Количество в мг." name="count">
        </div>
        <div>
            <button type="submit" class="btn btn-success col-1 mr-2 ${(countError??)?string('is-invalid', '')} form-control" formaction="/add-coffee">Добавить</button>
            <button type="submit" class="btn btn-danger col-1 ${(countError??)?string('is-invalid', '')} form-control" formaction="/remove-coffee">Убрать</button>
            <#if countError??>
                <div class="invalid-feedback" style="color: red">
                    ${countError}
                </div>
            </#if>
        </div>
    </form>
    </body>
    </html>
</@c.page>
