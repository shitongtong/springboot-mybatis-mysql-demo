<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>demo</title>
</head>
<#setting datetime_format="yyyy-MM-dd HH:mm:ss"/>
<#setting number_format="#">
<body>
    <table>
        <thead>
            这是一个demo
            <tr>
                <th>id</th>
                <th>内容</th>
                <th>状态</th>
                <th>创建时间</th>
                <th>更新时间</th>
            </tr>
        </thead>
        <tbody>
        <#list demoList as item>
            <tr>
                <td>${item.id}</td>
                <td>${item.content}</td>
                <td>${item.status}</td>
                <td>${item.createTime?datetime}</td>
                <td>${item.updateTime?datetime}</td>
            </tr>
        </#list>
        </tbody>
    </table>
</body>
</html>