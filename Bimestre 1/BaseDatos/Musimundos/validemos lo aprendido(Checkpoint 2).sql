select pais, count(*) 
from clientes
group by pais;

select id_genero, count(*)
from canciones
group by id_genero;

select sum(total)
from facturas;

select min(bytes)
from canciones;

select id_cliente, sum(total)
from facturas
group by id_cliente;

select id_album, avg(milisegundos)
from canciones
group by id_album;
