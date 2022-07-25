INSERT INTO TODO_LIST
(TODO_LIST_ID, NAME) VALUES
(1, 'Groceries'),
(2, 'Chores');

INSERT INTO TODO_ITEM
(TODO_LIST_ID, DESCRIPTION, COMPLETE) VALUES
(1, 'Juice', 'Y'),
(1, 'Bananas', 'Y'),
(1, 'Spinach', 'N'),
(1, 'Eggs', 'N'),
(1, 'Pizza', 'N'),
(1, 'Pancake mix', 'N'),

(2, 'Laundry', 'N'),
(2, 'Pay water bill', 'N'),
(2, 'Walk dog', 'Y'),
(2, 'Take out trash', 'N');
