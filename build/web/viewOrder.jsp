<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View Order Details</title>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css"
        integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css"
        integrity="sha512-NhSC1YmyruXifcj/KFRWoC561YpHpc5Jtzgvbuzx5VozKpWvQ+4nXhPdFgmx8xqexRcpAglTj9sIBWINXa8x5w=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>

    <link rel="stylesheet" href="assets/css/adminDashboard.css">
    <link rel="stylesheet" href="assets/css/viewOrder.css">

</head>

<body>

    <!-- header -->
    <div class="header">
        <div class="header__logo">
            <img src="assets/image/logo.png" alt="">
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
                    <img src="assets/image/ava1.jpg" alt="">
                </div>
                <div class="header__info">
                    <div class="header__name">
                        Nguyen An Phat
                    </div>
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
                <a href="login">
                    <span>
                        <i class="fa-solid fa-arrow-right-to-bracket"></i>
                    </span>
                    <h3>Logout</h3>
                </a>
            </div>
        </div>
        <div class="detail">
            <h1>Order Details</h1>
            <c:set var="c" value="${requestScope.order}" />
            <div class="detail__order">               
                <div class="detail-group">
                    <span>Order ID</span>
                    <div>${c.orderID}</div>
                </div>
                <div class="detail-group">
                    <span>Username</span>
                    <div>${c.username}</div>
                </div>
                <div class="detail-group">
                    <span>Fullname</span>
                    <div>${c.fullname}</div>
                </div>
                <div class="detail-group">
                    <span>Phone</span>
                    <div>${c.phone}</div>
                </div>
                <div class="detail-group">
                    <span>Order Date</span>
                    <div>${c.orderDate}</div>
                </div>
                <div class="detail-group">
                    <span>Total</span>
                    <div>${c.totalMoney}</div>
                </div>
                <div class="detail-group">
                    <span>Status</span>
                    <div>${c.status}</div>
                </div>
                <div class="detail__list">
                    <span>Order List</span>
                    <div class="detail__table">
                        <table>
                            <tr>
                                <th>Product</th>
                                <th>Price</th>
                                <th>Quantity</th>
                                <th>Subtotal</th>
                            </tr>
                            <c:forEach items="${requestScope.orderDetails}" var="c">
                            <tr>
                                <td class="detail__product">
                                    <div>
                                        <img src="${c.image}" alt="">
                                        <span>${c.name}</span>
                                    </div>
                                </td>
                                <td class="detail__price">
                                    ${c.price}
                                </td>
                                <td class="detail__quantity">
                                    ${c.quantity}
                                </td>
                                <td class="detail__subtotal">
                                    ${c.subtotal}
                                </td>
                            </tr>
                         </c:forEach>    
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- End main -->

</body>

</html>