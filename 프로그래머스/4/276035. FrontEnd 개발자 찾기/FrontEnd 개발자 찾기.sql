select id, email, first_name, last_name
from developers
where skill_code & (select code from skillcodes where name = 'JavaScript')
or skill_code & (select code from skillcodes where name = 'React')
or skill_code & (select code from skillcodes where name = 'Vue')
order by id;