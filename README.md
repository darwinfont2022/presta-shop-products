# Presta-Shop-Service

### Objetivos:

1. Interfaz RESTful: El microservicio expondrá endpoints RESTful que permitirán realizar operaciones CRUD sobre los recursos de PrestaShop, como manufacturers, suppliers, categorías, productos, stock e imagens.
2. Conversión de Datos: Implementación de un mecanismo para transformar datos entre formatos JSON y XML, facilitando la interoperabilidad con otras aplicaciones y servicios que requieren diferentes formatos de comunicación.

### Variable de entorno ```.env```
- PRESTASHOP_API_KEY
- PRESTASHOP_BASE_URL

### Endpoints
`/manufacturer`
> Metodos: `POST` `GET` `PUT` `DELETE`

`/suppliers`
> Metodos: `POST` `GET` `PUT` `DELETE`

`/categories`
> Metodos: `POST` `GET` `PUT` `DELETE`

`/products`
> Metodos: `POST` `GET` `PUT` `DELETE`

`/stock`
> Metodos: `GET` `PATCH`

`/images`
> Metodos: `POST`

