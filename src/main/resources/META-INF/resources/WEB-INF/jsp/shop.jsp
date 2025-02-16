<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<html>
<head>
    <title>Shop Now</title>
    <style>
        .product-card {
            border: 1px solid #ddd;
            border-radius: 8px;
            padding: 15px;
            margin-bottom: 20px;
            transition: transform 0.2s, box-shadow 0.2s;
        }

        .product-card:hover {
            transform: scale(1.02);
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        .product-image {
            width: 100%;
            height: 150px;
            object-fit: contain;
            border-radius: 8px;
        }

        .product-name {
            font-size: 1.2em;
            font-weight: bold;
            margin: 10px 0;
        }

        .product-description {
            font-size: 0.9em;
            color: #555;
            margin-bottom: 10px;
        }

        .product-price {
            font-size: 1.1em;
            font-weight: bold;
            color: rebeccapurple;
        }

        .cart-badge {
            font-size: 0.75em;
            vertical-align: top;
            margin-left: 5px;
        }

        .search-bar {
            max-width: 300px;
            margin-bottom: 20px;
        }

        .no-products {
            text-align: center;
            font-size: 1.2em;
            color: #777;
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <div class="container">
        <!-- Page Header -->
        <div class="d-flex justify-content-between align-items-center mb-4">
            <h1 style="color: rebeccapurple;">Shop Now!</h1>
            <a href="/cart" class="btn btn-outline-primary position-relative">
                <i class="bi bi-cart"></i> Cart
                <c:if test="${not empty cartCount && cartCount > 0}">
                    <span class="cart-badge badge bg-danger">${cartCount}</span>
                </c:if>
            </a>
        </div>
        <hr>

        <!-- Search Bar -->
        <div class="input-group search-bar">
            <input type="text" id="searchInput" class="form-control" placeholder="Search products..." aria-label="Search products">
            <button class="btn btn-outline-secondary" type="button" onclick="filterProducts()">
                <i class="bi bi-search"></i>
            </button>
        </div>

        <!-- Product Cards -->
        <div class="row" id="productContainer">
            <c:if test="${empty items}">
                <div class="no-products">No products available.</div>
            </c:if>
            <c:forEach items="${items}" var="Item">
                <c:if test="${not empty Item.itemName and not empty Item.description and not empty Item.imageUrl}">
                    <div class="col-md-4 col-sm-6 mb-4 product-card">
                        <img src="${Item.imageUrl}" class="product-image" alt="${Item.itemName}">
                        <div class="product-name">${Item.itemName}</div>
                        <div class="product-description">${Item.description}</div>
                        <div class="product-price">$${Item.price}</div>
                        <c:url var="addToCartUrl" value="add-cart">
                            <c:param name="id" value="${Item.id}" />
                            <c:param name="itemName" value="${Item.itemName}" />
                            <c:param name="description" value="${Item.description}" />
                            <c:param name="price" value="${Item.price}" />
                            <c:param name="done" value="false" />
                            <c:param name="imageUrl" value="${Item.imageUrl}" />
                        </c:url>
                        <a href="${addToCartUrl}" class="btn btn-primary btn-sm">Add to Cart</a>
                    </div>
                </c:if>
            </c:forEach>
        </div>
    </div>

    <!-- Bootstrap Icons -->
    <%@ include file="common/footer.jspf"%>

    <script>
        // Function to filter products by name
        function filterProducts() {
            const input = document.getElementById('searchInput').value.toLowerCase();
            const cards = document.querySelectorAll('.product-card');

            cards.forEach(card => {
                const productName = card.querySelector('.product-name').textContent.toLowerCase();
                if (productName.includes(input)) {
                    card.style.display = 'block';
                } else {
                    card.style.display = 'none';
                }
            });
        }

        // Add event listener for search input
        document.getElementById('searchInput').addEventListener('keyup', filterProducts);
    </script>
</body>
</html>