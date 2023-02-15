# MySQL Connector
- 注意，MySQL版本大于8.0.0
- 使用编译器打开的时候注意确认引入lib中的jar包

## 使用

<mark>**首先需要在文件【DataBase_Info/DataBase_Info.java】中修改数据库的用户名、数据库的密码和数据库名称**</mark>

|使用的函数|作用|参数|备注|
|-|-|-|-|
|DeleteByCondition.deleteDataFromTable|按照条件删除数据|【表名】tableName<br/>【条件】condition|/
|DeleteByID.deleteDataFromTable|按照ID删除数据|【表名】tableName<br/>【ID名称】id|/
|Read.readFromMySQL|读取表数据|【表名】tableName|返回二维数组
|Update.updateSQL|更新数据|【表名】tableName<br/>【更新列】columnName<br/>【新数据】newValue<br/>【条件】condition|/
|Write.writeToSQL|写入数据|【表名】tableName<br/>【数据内容】data|data为可变长度参数