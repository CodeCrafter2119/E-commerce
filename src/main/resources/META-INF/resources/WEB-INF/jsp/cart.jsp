<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<table class="table">
    <thead>
        <tr>
            <th>Image</th>
            <th>User Name</th>
            <th>Item Name</th>
            <th>Description</th>
            <th>Price</th>
            <th>Action</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${cartItems}" var="Item">
            <tr>
                <td>
                    <img src="${Item.imageUrl}" alt="Item Image" style="max-width: 100px; height: auto;" />
                </td>
                <td>${Item.username}</td>
                <td>${Item.itemName}</td>
                <td>${Item.description}</td>
                <td>${Item.price}</td>
                <td>
                    <a href="delete-cart?id=${Item.id}" class="btn btn-warning">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<!-- Order Button -->
<div class="text-center mt-4">
    <form action="place-order" method="POST">
        <button type="submit" class="btn btn-success">Place Order</button>
    </form>
</div>

<%@ include file="common/footer.jspf"%>