<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Product</title>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css"
        integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css"
        integrity="sha512-NhSC1YmyruXifcj/KFRWoC561YpHpc5Jtzgvbuzx5VozKpWvQ+4nXhPdFgmx8xqexRcpAglTj9sIBWINXa8x5w=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link href="https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css" rel="stylesheet" />

    <link rel="stylesheet" href="assets/css/adminDashboard.css" />
    <link rel="stylesheet" href="assets/css/addProduct.css" />

</head>

<body>

    <!-- header -->
    <div class="header">
        <div class="header__logo">
            <img src="assets/image/logo.png" alt="" />
            <span>Furnish</span>
        </div>
        <div class="header__nav">
            <ul class="header__icon">
                <li>
                    <i class="fa-solid fa-magnifying-glass"></i>
                </li>
                <li>
                    <i class="fa-regular fa-bell"></i>
                </li>
                <li>
                    <i class="fa-regular fa-envelope"></i>
                </li>
            </ul>
            <div class="header__manager">
                <div class="header__avatar">
                    <img src="assets/image/ava1.jpg" alt="" />
                </div>
                <div class="header__info">
                    <div class="header__name">Nguyen An Phat</div>
                    <span>Manager</span>
                </div>
            </div>
        </div>
    </div>
    <!-- End header -->

    <!-- main -->
    <div class="main">
        <div class="main__sidebar">
            <ul>
                <li>
                    <a href="admin.html">
                        <span><i class='bx bx-home'></i></span>
                        <h3>Dashboard</h3>
                    </a>
                </li>
                <li>
                    <a href="listItemManager">
                        <span><i class='bx bx-shopping-bag'></i></span>
                        <h3>Product</h3>
                    </a>
                </li>
                <li>
                    <a href="categoryManager">
                        <span><i class='bx bx-category'></i></span>
                        <h3>Category</h3>
                    </a>
                </li>
                <li>
                    <a href="userManager">
                        <span><i class='bx bx-user'></i></span>
                        <h3>Customers</h3>
                    </a>
                </li>
                <li>
                    <a href="listOrdersManager">
                        <span><i class='bx bx-cart'></i></span>
                        <h3>Orders</h3>
                    </a>
                </li>
            </ul>
            <div class="main__logout">
                <a href="logout">
                    <span>
                        <i class="fa-solid fa-arrow-right-to-bracket"></i>
                    </span>
                    <h3>Logout</h3>
                </a>
            </div>
        </div>
        <div class="product">
            <h1>Update Product</h1>
            <c:set var="c" value="${requestScope.item}" />
            <form class="product__form" action="updateItem" method="post">
                <div class="form-group">
                    <label for="itemID">ID</label>
                    <input type="text" id="itemID" name="itemID" value="${c.id}" required />
                </div>
                <div class="form-group">
                    <label for="name">Product Name</label>
                    <input type="text" id="name" name="name" value="${c.name}" required />
                </div>
                <div class="form-group">
                    <label for="stock">Quantity</label>
                    <input type="text" id="stock" name="stock" value="${c.stock}" required />
                </div>
                <div class="form-group">
                  <label for="costPrice">Cost Price</label>
                  <input type="text" id="costPrice" name="costPrice" value="${c.cost}" required />
                </div>
                <div class="form-group">
                  <label for="sellPrice">Sell Price</label>
                  <input type="text" id="sellPrice" name="sellPrice" value="${c.sell}" required />
                </div>
                <div class="form-group">
                  <label for="image">Image URL</label>
                  <input type="text" id="image" name="image" value="${c.image}" required />
                </div>
                <div class="form-group">
                  <label for="description">Description</label>
                  <textarea id="description" name="description" value="${c.description}" required></textarea>
                </div>
                <div class="form-group">
                  <label for="categoryID">Category</label>
                  <select name="categoryID" id="categoryID" value="${c.category.id}">
                    <option value="cat1">Living Room</option>
                    <option value="cat2">Bedroom</option>
                    <option value="cat3">Kitchen & Dining</option>
                    <option value="cat4">Office</option>
                    <option value="cat5">Entry & Mudroom</option>
                    <option value="cat6">Outdoor & Patio</option>
                    <option value="cat7">Small Spaces</option>
                    <option value="cat8">Bathroom</option>
                  </select>
                </div>
                <div class="form__btn">
                    <button type="submit">Update</button>
                    <a href="listItemManager">Cancel</a>
                </div>
            </form>
        </div>
    </div>
    <!-- End main -->

</body>

</html>