
--es1
select * from public.clienti
where nome = 'Mario';

--es2
select nome,cognome from public.clienti
where anno_nascita = 1982;

--es3
select count(*) from public.fatture
where iva = 20;

--es4
select * from public.prodotti
where extract (year from data_attivazione)=2017 and (in_produzione = true OR in_commercio = true);

--es5
select *
from public.fatture f, public.clienti cl
where f.id_cliente = cl.numero_cliente and f.importo < 1000;

--es6
select numero_fattura, importo, iva, data_fattura, denominazione
from public.fatture f, public.fornitori fo
where f.numero_fornitore = fo.numero_fornitore;

--es7
select extract(year from data_fattura), count(*)
from public.fatture
where iva=20
group by extract(year from data_fattura);

--es8
select extract(year from data_fattura), count(*), sum(importo)
from public.fatture
group by extract(year from data_fattura);






