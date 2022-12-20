-- order detail modals 
SELECT * FROM module_6_sprint_2_demo.orders;
SELECT 
    order_detail.order_id,
    order_detail.quantity,
    books.name,
    books.price,
    order_detail.quantity * books.price AS book_money
FROM
    order_detail
        JOIN
    orders ON orders.id = order_detail.order_id
        JOIN
    books ON books.id = order_detail.book_id
WHERE
    orders.id = 2; 