package com.italo.projetos.util;

import java.util.Calendar;
import java.util.Date;

public class Util {

	public Date gerarDataDesativacao(Date dataAtivacao) {
		Calendar c = Calendar.getInstance();
		c.setTime(dataAtivacao);
		c.add(Calendar.YEAR, 1);
		return c.getTime();
	}
}
