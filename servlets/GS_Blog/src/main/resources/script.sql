create DATABASE `blog` CHARACTER SET utf8 COLLATE utf8_general_ci;

use `blog`;

CREATE TABLE categories (
	id INT(11) NOT NULL AUTO_INCREMENT, 
	NAME VARCHAR(255) NOT NULL,
	PRIMARY KEY (id)
) ;

CREATE TABLE posts (
	id INT(11) NOT NULL AUTO_INCREMENT, 
	title VARCHAR(255) NOT NULL, 
	summary TEXT NOT NULL, 
	body TEXT NOT NULL, 
	categoryId INT(11) NOT NULL , 
	PRIMARY KEY (id)
) ;
	
ALTER TABLE posts ADD CONSTRAINT CONSTR_POST_CATEGORY FOREIGN KEY (categoryId) REFERENCES categories (id);


INSERT INTO `categories` (`id`, `name`) VALUES 
  (1,'News'),
  (2,'Java');

INSERT INTO `posts` (`id`, `title`, `summary`, `body`, `categoryId`) VALUES
  (1,'Test title', 'Test summary', 'Test body', 1);

INSERT INTO `posts` (`id`, `title`, `summary`, `body`, `categoryId`) VALUES
  (2,'Заголовок', 'Test summary', 'Test body', 1);

COMMIT;