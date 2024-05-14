document.addEventListener('DOMContentLoaded', () => {
    const menuDiv = document.getElementById('menu');
    const menuForm = document.getElementById('menuForm');

    // Fetch and display menu items
    fetch('http://localhost:8080/api/menu')
        .then(response => response.json())
        .then(data => {
            data.forEach(item => {
                const menuItemDiv = document.createElement('div');
                menuItemDiv.classList.add('menu-item');
                menuItemDiv.innerHTML = `
                    <h3>${item.name}</h3>
                    <p>${item.description}</p>
                    <p>Price: $${item.price.toFixed(2)}</p>
                    <p>Category: ${item.category}</p>
                    <button onclick="deleteMenuItem('${item.id}')">Delete</button>
                `;
                menuDiv.appendChild(menuItemDiv);
            });
        })
        .catch(error => console.error('Error:', error));

    // Handle form submission
    menuForm.addEventListener('submit', event => {
        event.preventDefault();
        const formData = new FormData(menuForm);
        const menuItem = {
            name: formData.get('name'),
            description: formData.get('description'),
            price: parseFloat(formData.get('price')),
            category: formData.get('category')
        };

        fetch('http://localhost:8080/api/menu', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(menuItem)
        })
            .then(response => response.json())
            .then(data => {
                alert('Menu item added!');
                window.location.reload(); // Reload to show the new item
            })
            .catch(error => console.error('Error:', error));
    });
});

function deleteMenuItem(id) {
    fetch(`http://localhost:8080/api/menu/${id}`, {
        method: 'DELETE'
    })
        .then(() => {
            alert('Menu item deleted!');
            window.location.reload(); // Reload to remove the deleted item
        })
        .catch(error => console.error('Error:', error));
}
