CREATE OR REPLACE FUNCTION douban_book_id_init()
  RETURNS int4 AS
$BODY$
	DECLARE
		num int4 := 1100000;
		r RECORD;
	BEGIN
	    while(num < 9999999) LOOP
			insert into douban_book_id(douban_book_id,isscapy,add_date) values(num,0,now());
			num = num + 1;
		END LOOP;
	    return 1;
	END;
$BODY$

LANGUAGE 'plpgsql' VOLATILE;