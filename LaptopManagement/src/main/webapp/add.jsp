<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    
    <form action="addLap">
        <label for="">Laptop Id</label><br>
        <input type="text" name="lid"> <br>
        <label for="">Laptop Brand</label><br>
        <input type="text" name="brand"><br>
        <label for="">Laptop Price</label><br>
        <input type="text" name="price"><br>
        <label for="">Ram Size</label><br>
        <input type="text" name="ram"><br>
        <label for="">Color</label><br>
        <input type="text" name="color"><br>
        <button type="submit">Add Data</button><br>
    </form><br><br>
    <form action="main.jsp">
        <button type="submit">Go Back To Main</button>
    </form>

    <br><br>
    <h1 style="color: blue;">${msg}</h1>
</body>
</html>