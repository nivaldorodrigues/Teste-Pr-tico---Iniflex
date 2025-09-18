import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.text.NumberFormat;

class Pessoa {
    private String nome;
    private LocalDate dataNascimento;

    public Pessoa(String nome, LocalDate dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Data de Nascimento: " +
                dataNascimento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}

class Funcionario extends Pessoa {
    private BigDecimal salario;
    private String funcao;

    public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
        super(nome, dataNascimento);
        this.salario = salario.setScale(2, RoundingMode.HALF_UP);
        this.funcao = funcao;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario.setScale(2, RoundingMode.HALF_UP);
    }

    public String getFuncao() {
        return funcao;
    }

    @Override
    public String toString() {
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        int idade = Period.between(getDataNascimento(), LocalDate.of(2025, 9, 17)).getYears();
        return super.toString() + ", Idade: " + idade + " anos, Salário: " + nf.format(salario) + ", Função: " + funcao;
    }
}

public class Principal {
    public static void main(String[] args) {
        DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        LocalDate dataAtual = LocalDate.of(2025, 9, 17);

        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(new Funcionario("João", LocalDate.parse("12/10/1990", formatterData), new BigDecimal("2308.34"), "Operador"));
        funcionarios.add(new Funcionario("Caio", LocalDate.parse("02/05/1961", formatterData), new BigDecimal("983.14"), "Coordenador"));
        funcionarios.add(new Funcionario("Miguel", LocalDate.parse("14/01/1985", formatterData), new BigDecimal("1931.68"), "Recepcionista"));
        funcionarios.add(new Funcionario("Arthur", LocalDate.parse("15/11/1999", formatterData), new BigDecimal("1582.72"), "Operador"));
        funcionarios.add(new Funcionario("Laura", LocalDate.parse("31/07/1993", formatterData), new BigDecimal("4071.84"), "Contador"));
        funcionarios.add(new Funcionario("Heloisa", LocalDate.parse("24/05/2003", formatterData), new BigDecimal("1607.85"), "Eletricista"));
        funcionarios.add(new Funcionario("Helena", LocalDate.parse("02/09/1996", formatterData), new BigDecimal("2799.93"), "Gerente"));

        System.out.println("=== 3.1 - Lista inicial de funcionários ===");
        funcionarios.forEach(System.out::println);
        System.out.println();

        // 3.2 - Remover João
        funcionarios.removeIf(f -> f.getNome().equals("João"));
        System.out.println("=== 3.2 - Após remoção de João ===");
        funcionarios.forEach(System.out::println);
        System.out.println();

        // 3.4 - Aumento de 10%
        for (Funcionario f : funcionarios) {
            f.setSalario(f.getSalario().multiply(new BigDecimal("1.10")));
        }
        System.out.println("=== 3.4 - Após aumento de 10% ===");
        funcionarios.forEach(System.out::println);
        System.out.println();

        // 3.5 e 3.6 - Agrupar por função
        Map<String, List<Funcionario>> agrupadoPorFuncao = funcionarios.stream()
                .collect(Collectors.groupingBy(Funcionario::getFuncao));
        System.out.println("=== 3.6 - Funcionários agrupados por função ===");
        agrupadoPorFuncao.forEach((funcao, lista) -> {
            System.out.println("Função: " + funcao);
            lista.forEach(System.out::println);
            System.out.println();
        });

        // 3.8 - Aniversariantes em outubro e dezembro
        System.out.println("=== 3.8 - Aniversariantes em outubro e dezembro ===");
        List<Funcionario> aniversariantes = funcionarios.stream()
                .filter(f -> {
                    int mes = f.getDataNascimento().getMonthValue();
                    return mes == 10 || mes == 12;
                })
                .toList();
        if (aniversariantes.isEmpty()) {
            System.out.println("Nenhum funcionário faz aniversário em outubro ou dezembro.");
        } else {
            aniversariantes.forEach(System.out::println);
        }
        System.out.println();

        // 3.9 - Funcionário com maior idade
        System.out.println("=== 3.9 - Funcionário com maior idade ===");
        Funcionario maisVelho = funcionarios.stream()
                .max(Comparator.comparingInt(f -> Period.between(f.getDataNascimento(), dataAtual).getYears()))
                .orElse(null);
        if (maisVelho != null) {
            int idade = Period.between(maisVelho.getDataNascimento(), dataAtual).getYears();
            System.out.println("Nome: " + maisVelho.getNome() + ", Idade: " + idade + " anos");
        }
        System.out.println();

        // 3.10 - Ordem alfabética
        List<Funcionario> ordenadosAlfabeticamente = new ArrayList<>(funcionarios);
        ordenadosAlfabeticamente.sort(Comparator.comparing(Funcionario::getNome));
        System.out.println("=== 3.10 - Funcionários em ordem alfabética ===");
        ordenadosAlfabeticamente.forEach(System.out::println);
        System.out.println();

        // 3.11 - Total dos salários
        System.out.println("=== 3.11 - Total dos salários ===");
        BigDecimal totalSalarios = funcionarios.stream()
                .map(Funcionario::getSalario)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("Total: " + nf.format(totalSalarios));
        System.out.println();

        // 3.12 - Salários mínimos
        BigDecimal salarioMinimo = new BigDecimal("1212.00");
        System.out.println("=== 3.12 - Salários mínimos por funcionário ===");
        for (Funcionario f : funcionarios) {
            BigDecimal qtdSalMin = f.getSalario().divide(salarioMinimo, 2, RoundingMode.HALF_UP);
            System.out.println(f.getNome() + " ganha " + qtdSalMin + " salários mínimos.");
        }
    }
}
