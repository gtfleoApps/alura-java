package alura.com.br.loja;

import java.math.BigDecimal;

import alura.com.br.loja.impostodec.CalculadoraDeImpostosDec;
import alura.com.br.loja.impostodec.ICMSDec;
import alura.com.br.loja.impostodec.ISSDec;
import alura.com.br.loja.orcamento.ItemOrcamento;
import alura.com.br.loja.orcamento.Orcamento;

public class TesteDecorator {

    public void testar() {

        Orcamento orcamento = new Orcamento();
        orcamento.adicionarItem(new ItemOrcamento(new BigDecimal("100")));
        CalculadoraDeImpostosDec calculadora = new CalculadoraDeImpostosDec();

        System.out.println(calculadora.calcular(orcamento, new ICMSDec(new ISSDec())));

    }

}
