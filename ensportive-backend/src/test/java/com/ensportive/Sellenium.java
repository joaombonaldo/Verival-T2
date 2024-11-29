package com.ensportive;

import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import static org.apache.naming.SelectorContext.prefix;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class Sellenium {
     /*
    * Teste de criação de turma com sucesso
    * dado que:
    *  - o usuário está logado
    * - o usuário está na página de turmas
    * - o usuário passa os dados corretos
    * quando:
    * - o usuário preenche os campos corretamente
    * - o usuário clica no botão de criar turma
    * então:
    * - a turma é criada com sucesso
    * - a turma é exibida na lista de turmas
     */
    @Test
    public void testeGerarAulas12AoCriarTurma_Ok(){
        System.setProperty("webdriver.chorme.driver","C:\\Users\\vizzo\\Downloads\\chromedriver-win64\\chromedriver-win64\\");
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:4200/login");
        driver.manage().window().maximize();

        WebElement inputElementByPlaceholder = driver.findElement(By.xpath("/html/body/app-root/app-login/div/div[2]/div[1]/input"));
        inputElementByPlaceholder.sendKeys("admin");
        WebElement inputElementByPlaceholder2 = driver.findElement(By.xpath("/html/body/app-root/app-login/div/div[2]/div[2]/div[1]/input"));
        inputElementByPlaceholder2.sendKeys("123");
        WebElement entrar = driver.findElement(By.xpath("/html/body/app-root/app-login/div/div[2]/button"));
        entrar.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

        WebElement professorButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/app-header/header/div/div/ul/li[3]")));
        professorButton.click();

        WebElement adicionarProfessor = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/app-teachers/div/div[1]/div/app-teacher-modal/div/button")));
        adicionarProfessor.click();

        WebElement inputnomeProfessor = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[1]/div/input"));
        inputnomeProfessor.sendKeys("Joao Pedro da Silva Kriger");

        WebElement inputemailProfessor = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[2]/div/input"));
        inputemailProfessor.sendKeys(gerarEmail());

        WebElement inputTelefoneProfessor = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[3]/div[1]/input"));
        inputTelefoneProfessor.sendKeys(gerarNumeroTelefone());

        WebElement inputTypeProfessor = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[3]/div[2]/div[2]/input"));
        inputTypeProfessor.click();

        WebElement createProfessor = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[4]/button[2]"));
        createProfessor.click();

        WebElement turmasButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/app-header/header/div/div/ul/li[4]/a")));
        turmasButton.click();
        WebElement botaoAdicionar = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/app-admin-courses/div/div[1]/div/app-course-modal/div/button")));
        botaoAdicionar.click();

        WebElement inputElementByPlaceholder3 = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[1]/div[1]/div[1]/select"));
        inputElementByPlaceholder3.click();

        WebElement inputElementByPlaceholder4 = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[1]/div[1]/div[1]/select/option[2]"));
        inputElementByPlaceholder4.click();

        WebElement inputElementByPlaceholder5 = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[1]/div[2]/div[1]/input"));
        inputElementByPlaceholder5.sendKeys("12");

        WebElement inputElementByPlaceholder6 = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[1]/div[2]/div[1]/input"));
        inputElementByPlaceholder5.sendKeys("12");

        WebElement inputElementByPlaceholder7 = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[1]/div[1]/div[2]/div/select"));
        inputElementByPlaceholder7.click();

        WebElement inputElementByPlaceholder8 = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[1]/div[1]/div[2]/div/select/option[3]"));
        inputElementByPlaceholder8.click();

        WebElement inputElementByPlaceholder9 = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[1]/div[2]/div[2]/input"));
        inputElementByPlaceholder9.sendKeys("1200");

        WebElement inputElementByPlaceholder10 = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[1]/div[1]/div[4]/select"));
        inputElementByPlaceholder10.click();

        WebElement inputElementByPlaceholder11 = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[1]/div[1]/div[4]/select/option[2]"));
        inputElementByPlaceholder11.click();

        WebElement inputElementByPlaceholder12 = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[1]/div[2]/div[3]/select"));
        inputElementByPlaceholder12.click();

        WebElement inputElementByPlaceholder13 = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[1]/div[2]/div[3]/select/option[2]"));
        inputElementByPlaceholder13.click();

        WebElement inputElementByPlaceholder14 = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[1]/div[2]/div[4]/input"));
        inputElementByPlaceholder14.sendKeys("10");

        WebElement inputElementByPlaceholder15 = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[1]/div[1]/div[3]/select"));
        inputElementByPlaceholder15.click();

        WebElement inputElementByPlaceholder16 = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[1]/div[1]/div[3]/select/option[2]"));
        inputElementByPlaceholder16.click();

        WebElement inputElementByPlaceholder17 = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[2]/button[2]"));
        inputElementByPlaceholder17.click();


        WebElement resultTurma = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/app-admin-courses/div/div[2]/table/tbody/tr/td[1]/ngb-highlight")));
        assert resultTurma.getText().equals("Tênis");
        resultTurma = driver.findElement(By.xpath("/html/body/app-root/app-admin-courses/div/div[2]/table/tbody/tr/td[2]/ngb-highlight"));
        assert resultTurma.getText().equals("Iniciante 1");
        resultTurma = driver.findElement(By.xpath("/html/body/app-root/app-admin-courses/div/div[2]/table/tbody/tr/td[3]/ngb-highlight"));
        assert resultTurma.getText().equals("Junior");
        resultTurma = driver.findElement(By.xpath("/html/body/app-root/app-admin-courses/div/div[2]/table/tbody/tr/td[4]/ngb-highlight"));
        assert resultTurma.getText().equals("Segunda-feira");
        resultTurma = driver.findElement(By.xpath("/html/body/app-root/app-admin-courses/div/div[2]/table/tbody/tr/td[5]/ngb-highlight"));
        assert resultTurma.getText().equals("12:00:00");
        resultTurma = driver.findElement(By.xpath("/html/body/app-root/app-admin-courses/div/div[2]/table/tbody/tr/td[6]/ngb-highlight"));
        assert resultTurma.getText().equals("1,212");
        resultTurma = driver.findElement(By.xpath("/html/body/app-root/app-admin-courses/div/div[2]/table/tbody/tr/td[7]/ngb-highlight"));
        assert resultTurma.getText().equals("Não");


        WebElement botaoAbaDeAulas = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/app-header/header/div/div/ul/li[6]")));
        botaoAbaDeAulas.click();
        String[] valores = {"Joao Pedro da Silva Kriger", "1212", "Junior", "Tênis", "12:00:00", "1,212", "Não"};
        WebElement dadosCraidosdeAulas;
        for(int i = 1;i<12;i++){
            for (int j = 1; j < 3; j++) {
                dadosCraidosdeAulas = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/app-lessons/div/div[2]/table/tbody/tr["+i+"]/td["+j+"]/ngb-highlight")));
                assert dadosCraidosdeAulas.getText().equals(valores[j-1]);
            }
        }
        turmasButton.click();

        // Clicar no botão "Deletar"
        WebElement botaoDeletar = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/app-root/app-admin-courses/div/div[2]/table/tbody/tr/td[8]/div/app-confirm-modal/div/button")
        ));
        botaoDeletar.click();

        WebElement botaoConfirmar = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/ngb-modal-window/div/div/div[3]/button[2]")
        ));
        botaoConfirmar.click();

        WebElement validarDeletar = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//td[contains(text(), 'Nenhuma turma encontrada') and @colspan='7']")
        ));

        assert validarDeletar.getText().trim().equals("Nenhuma turma encontrada");

        botaoAbaDeAulas.click();

        WebElement validarDeletaraula = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//td[contains(text(), 'Nenhuma aula encontrada') and @colspan='4']")
        ));

        assert validarDeletaraula.getText().trim().equals("Nenhuma aula encontrada");

        driver.quit();
    }
     /*
    * Teste de erro ao criar turma com número de alunos negativo
    * dado que:
    * - o usuário está logado
    * - o usuário está na criando uma turma
    * quando:
    * - o usuário preenche o campo de quantidade de alunos com um número negativo
    * então:
    * - o sistema exibe uma mensagem de erro
    * - o botão de criar é desabilitada
     */
    @Test
    public void testeErroCriarTurma_Numero_de_aluno_Negativo(){
        System.setProperty("webdriver.chorme.driver","C:\\Users\\vizzo\\Downloads\\chromedriver-win64\\chromedriver-win64\\");
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:4200/login");
        driver.manage().window().maximize();

        WebElement inputElementByPlaceholder = driver.findElement(By.xpath("/html/body/app-root/app-login/div/div[2]/div[1]/input"));
        inputElementByPlaceholder.sendKeys("admin");
        WebElement inputElementByPlaceholder2 = driver.findElement(By.xpath("/html/body/app-root/app-login/div/div[2]/div[2]/div[1]/input"));
        inputElementByPlaceholder2.sendKeys("123");
        WebElement entrar = driver.findElement(By.xpath("/html/body/app-root/app-login/div/div[2]/button"));
        entrar.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        WebElement turmasButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/app-header/header/div/div/ul/li[4]/a")));
        turmasButton.click();
        WebElement botaoAdicionar = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/app-admin-courses/div/div[1]/div/app-course-modal/div/button")));
        botaoAdicionar.click();

        WebElement inputElementByPlaceholder5 = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[1]/div[2]/div[1]/input"));
        inputElementByPlaceholder5.sendKeys("-1");

        WebElement inputElementByPlaceholder15 = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[1]/div[1]/div[3]/select"));
        inputElementByPlaceholder15.click();

        WebElement errorLable = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[1]/div[2]/div[1]/div")));

        assert errorLable.getText().trim().equals("Número de alunos é obrigatório e deve ser maior que zero.");
        driver.quit();
    }
    /*
    * Teste de erro ao criar turma com capacidade menor que o número de alunos
    * dado que:
    * - o usuário está logado
    * - o usuário está na página de turmas
    * quando:
    * - o usuário preenche passa capacidade menor que o número de alunos
    * então:
    * - o sistema exibe uma mensagem de erro
    * - o botão de criar é desabilitada
     */
    @Test
    public void testeErroAoTentarCriarAulaComCapacidadeMenorQueNumeroDeAlunos() {
        System.setProperty("webdriver.chorme.driver", "C:\\Users\\vizzo\\Downloads\\chromedriver-win64\\chromedriver-win64\\");
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:4200/login");
        driver.manage().window().maximize();

        WebElement inputElementByPlaceholder = driver.findElement(By.xpath("/html/body/app-root/app-login/div/div[2]/div[1]/input"));
        inputElementByPlaceholder.sendKeys("admin");
        WebElement inputElementByPlaceholder2 = driver.findElement(By.xpath("/html/body/app-root/app-login/div/div[2]/div[2]/div[1]/input"));
        inputElementByPlaceholder2.sendKeys("123");
        WebElement entrar = driver.findElement(By.xpath("/html/body/app-root/app-login/div/div[2]/button"));
        entrar.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));


        WebElement professorButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/app-header/header/div/div/ul/li[3]")));
        professorButton.click();

        WebElement adicionarProfessor = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/app-teachers/div/div[1]/div/app-teacher-modal/div/button")));
        adicionarProfessor.click();

        WebElement inputnomeProfessor = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[1]/div/input"));
        inputnomeProfessor.sendKeys("Joao Pedro da Silva Kriger");

        WebElement inputemailProfessor = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[2]/div/input"));
        inputemailProfessor.sendKeys(gerarEmail());

        WebElement inputTelefoneProfessor = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[3]/div[1]/input"));
        inputTelefoneProfessor.sendKeys(gerarNumeroTelefone());

        WebElement inputTypeProfessor = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[3]/div[2]/div[2]/input"));
        inputTypeProfessor.click();

        WebElement createProfessor = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[4]/button[2]"));
        createProfessor.click();

        WebElement turmasButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/app-header/header/div/div/ul/li[4]/a")));
        turmasButton.click();
        WebElement botaoAdicionar = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/app-admin-courses/div/div[1]/div/app-course-modal/div/button")));
        botaoAdicionar.click();

        WebElement inputElementByPlaceholder3 = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[1]/div[1]/div[1]/select"));
        inputElementByPlaceholder3.click();

        WebElement inputElementByPlaceholder4 = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[1]/div[1]/div[1]/select/option[2]"));
        inputElementByPlaceholder4.click();

        WebElement inputElementByPlaceholder5 = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[1]/div[2]/div[1]/input"));
        inputElementByPlaceholder5.sendKeys("12");

        WebElement inputElementByPlaceholder6 = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[1]/div[2]/div[1]/input"));
        inputElementByPlaceholder5.sendKeys("12");

        WebElement inputElementByPlaceholder7 = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[1]/div[1]/div[2]/div/select"));
        inputElementByPlaceholder7.click();

        WebElement inputElementByPlaceholder8 = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[1]/div[1]/div[2]/div/select/option[3]"));
        inputElementByPlaceholder8.click();

        WebElement inputElementByPlaceholder9 = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[1]/div[2]/div[2]/input"));
        inputElementByPlaceholder9.sendKeys("1200");

        WebElement inputElementByPlaceholder10 = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[1]/div[1]/div[4]/select"));
        inputElementByPlaceholder10.click();

        WebElement inputElementByPlaceholder11 = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[1]/div[1]/div[4]/select/option[2]"));
        inputElementByPlaceholder11.click();

        WebElement inputElementByPlaceholder12 = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[1]/div[2]/div[3]/select"));
        inputElementByPlaceholder12.click();

        WebElement inputElementByPlaceholder13 = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[1]/div[2]/div[3]/select/option[2]"));
        inputElementByPlaceholder13.click();

        WebElement alunodropdown = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[1]/div[1]/div[5]/ng-select"));
        alunodropdown.click();

        WebElement alunoEscolhido = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[1]/div[1]/div[5]/ng-select/ng-dropdown-panel/div/div[2]/div/span"));
        alunoEscolhido.click();

        WebElement inputElementByPlaceholder14 = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[1]/div[2]/div[4]/input"));
        inputElementByPlaceholder14.sendKeys("10");

        WebElement inputElementByPlaceholder15 = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[1]/div[1]/div[3]/select"));
        inputElementByPlaceholder15.click();

        WebElement inputElementByPlaceholder16 = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[1]/div[1]/div[3]/select/option[2]"));
        inputElementByPlaceholder16.click();

        WebElement inputElementByPlaceholder17 = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[2]/button[2]"));
        assert false : inputElementByPlaceholder17.isEnabled();
        driver.quit();
    }
     /*
    * Teste de erro ao criar turma com número de alunos 0
    * dado que:
    * - o usuário está logado
    * - o usuário está na página de turmas
    * quando:
    * - o usuário preenche passa número de alunos 0
    * - o usuário clica no botão de criar turma
    * então:
    * - o sistema exibe uma mensagem de erro
    * - o botão de criar é desabilitada
     */
    @Test
    public void testeErroAoCriarTurma_Com_numero_de_alunos_0(){
        System.setProperty("webdriver.chorme.driver","C:\\Users\\vizzo\\Downloads\\chromedriver-win64\\chromedriver-win64\\");
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:4200/login");
        driver.manage().window().maximize();

        WebElement inputElementByPlaceholder = driver.findElement(By.xpath("/html/body/app-root/app-login/div/div[2]/div[1]/input"));
        inputElementByPlaceholder.sendKeys("admin");
        WebElement inputElementByPlaceholder2 = driver.findElement(By.xpath("/html/body/app-root/app-login/div/div[2]/div[2]/div[1]/input"));
        inputElementByPlaceholder2.sendKeys("123");
        WebElement entrar = driver.findElement(By.xpath("/html/body/app-root/app-login/div/div[2]/button"));
        entrar.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        WebElement turmasButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/app-header/header/div/div/ul/li[4]/a")));
        turmasButton.click();
        WebElement botaoAdicionar = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/app-admin-courses/div/div[1]/div/app-course-modal/div/button")));
        botaoAdicionar.click();

        WebElement inputElementByPlaceholder3 = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[1]/div[1]/div[1]/select"));
        inputElementByPlaceholder3.click();

        WebElement inputElementByPlaceholder4 = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[1]/div[1]/div[1]/select/option[2]"));
        inputElementByPlaceholder4.click();

        WebElement inputElementByPlaceholder5 = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[1]/div[2]/div[1]/input"));
        inputElementByPlaceholder5.sendKeys("0");

        WebElement inputElementByPlaceholder6 = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[1]/div[2]/div[1]/input"));
        inputElementByPlaceholder5.sendKeys("12");

        WebElement inputElementByPlaceholder7 = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[1]/div[1]/div[2]/div/select"));
        inputElementByPlaceholder7.click();

        WebElement inputElementByPlaceholder8 = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[1]/div[1]/div[2]/div/select/option[3]"));
        inputElementByPlaceholder8.click();

        WebElement inputElementByPlaceholder9 = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[1]/div[2]/div[2]/input"));
        inputElementByPlaceholder9.sendKeys("1200");

        WebElement inputElementByPlaceholder10 = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[1]/div[1]/div[4]/select"));
        inputElementByPlaceholder10.click();

        WebElement inputElementByPlaceholder11 = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[1]/div[1]/div[4]/select/option[2]"));
        inputElementByPlaceholder11.click();

        WebElement inputElementByPlaceholder12 = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[1]/div[2]/div[3]/select"));
        inputElementByPlaceholder12.click();

        WebElement inputElementByPlaceholder13 = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[1]/div[2]/div[3]/select/option[2]"));
        inputElementByPlaceholder13.click();

        WebElement inputElementByPlaceholder14 = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[1]/div[2]/div[4]/input"));
        inputElementByPlaceholder14.sendKeys("10");

        WebElement inputElementByPlaceholder15 = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[1]/div[1]/div[3]/select"));
        inputElementByPlaceholder15.click();

        WebElement inputElementByPlaceholder16 = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[1]/div[1]/div[3]/select/option[2]"));
        inputElementByPlaceholder16.click();

        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[2]/button[2]")));
        assert false : button.isEnabled();

        driver.quit();
    }

    /*
    * Teste de erro ao criar turma sem professor informado
    * dado que:
    * - o usuário está logado
    * - o usuário está na página de turmas
    * quando:
    * - o usuário preenche passa o campo de professor vazio
    * então:
    * - o sistema exibe uma mensagem de erro
    * - o botão de criar é desabilitado
     */
    @Test
    public void testeErroCriarTurma_Sem_Professor(){
        System.setProperty("webdriver.chorme.driver","C:\\Users\\vizzo\\Downloads\\chromedriver-win64\\chromedriver-win64\\");
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:4200/login");
        driver.manage().window().maximize();

        WebElement inputElementByPlaceholder = driver.findElement(By.xpath("/html/body/app-root/app-login/div/div[2]/div[1]/input"));
        inputElementByPlaceholder.sendKeys("admin");
        WebElement inputElementByPlaceholder2 = driver.findElement(By.xpath("/html/body/app-root/app-login/div/div[2]/div[2]/div[1]/input"));
        inputElementByPlaceholder2.sendKeys("123");
        WebElement entrar = driver.findElement(By.xpath("/html/body/app-root/app-login/div/div[2]/button"));
        entrar.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

        WebElement turmasButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/app-header/header/div/div/ul/li[4]/a")));
        turmasButton.click();
        WebElement botaoAdicionar = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/app-admin-courses/div/div[1]/div/app-course-modal/div/button")));
        botaoAdicionar.click();

        WebElement inputElementByPlaceholder3 = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[1]/div[1]/div[1]/select"));
        inputElementByPlaceholder3.click();

        WebElement inputElementByPlaceholder4 = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[1]/div[1]/div[1]/select/option[2]"));
        inputElementByPlaceholder4.click();

        WebElement inputElementByPlaceholder5 = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[1]/div[2]/div[1]/input"));
        inputElementByPlaceholder5.sendKeys("12");

        WebElement inputElementByPlaceholder6 = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[1]/div[2]/div[1]/input"));
        inputElementByPlaceholder5.sendKeys("12");

        WebElement inputElementByPlaceholder7 = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[1]/div[1]/div[2]/div/select"));
        inputElementByPlaceholder7.click();

        WebElement inputElementByPlaceholder8 = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[1]/div[1]/div[2]/div/select/option[3]"));
        inputElementByPlaceholder8.click();

        WebElement inputElementByPlaceholder9 = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[1]/div[2]/div[2]/input"));
        inputElementByPlaceholder9.sendKeys("1200");

        WebElement inputElementByPlaceholder10 = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[1]/div[1]/div[4]/select"));
        inputElementByPlaceholder10.click();

        WebElement inputElementByPlaceholder11 = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[1]/div[1]/div[4]/select/option[1]"));
        inputElementByPlaceholder11.click();

        WebElement inputElementByPlaceholder12 = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[1]/div[2]/div[3]/select"));
        inputElementByPlaceholder12.click();

        WebElement inputElementByPlaceholder13 = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[1]/div[2]/div[3]/select/option[2]"));
        inputElementByPlaceholder13.click();

        WebElement inputElementByPlaceholder14 = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[1]/div[2]/div[4]/input"));
        inputElementByPlaceholder14.sendKeys("10");

        WebElement inputElementByPlaceholder15 = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[1]/div[1]/div[3]/select"));
        inputElementByPlaceholder15.click();

        WebElement inputElementByPlaceholder16 = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[1]/div[1]/div[3]/select/option[2]"));
        inputElementByPlaceholder16.click();

        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[1]/div[1]/div[4]/div")));
        assert button.getText().trim().equals("Professor é obrigatório.");
        driver.quit();
    }
    /*
    * Teste de erro ao criar turma sem plano informado
    * dado que:
    * - o usuário está logado
    * - o usuário está na página de turmas
    * quando:
    * - o usuário preenche passa o campo de plano vazio
    * então:
    * - o sistema exibe uma mensagem de erro
    * - o botão de criar é desabilitado
     */
    @Test
    public void testeErroCriarTurma_Sem_Plano(){
        System.setProperty("webdriver.chorme.driver","C:\\Users\\vizzo\\Downloads\\chromedriver-win64\\chromedriver-win64\\");
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:4200/login");
        driver.manage().window().maximize();

        WebElement inputElementByPlaceholder = driver.findElement(By.xpath("/html/body/app-root/app-login/div/div[2]/div[1]/input"));
        inputElementByPlaceholder.sendKeys("admin");
        WebElement inputElementByPlaceholder2 = driver.findElement(By.xpath("/html/body/app-root/app-login/div/div[2]/div[2]/div[1]/input"));
        inputElementByPlaceholder2.sendKeys("123");
        WebElement entrar = driver.findElement(By.xpath("/html/body/app-root/app-login/div/div[2]/button"));
        entrar.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

        WebElement turmasButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/app-header/header/div/div/ul/li[4]/a")));
        turmasButton.click();
        WebElement botaoAdicionar = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/app-admin-courses/div/div[1]/div/app-course-modal/div/button")));
        botaoAdicionar.click();

        WebElement inputElementByPlaceholder3 = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[1]/div[1]/div[1]/select"));
        inputElementByPlaceholder3.click();

        WebElement inputElementByPlaceholder4 = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[1]/div[1]/div[1]/select/option[2]"));
        inputElementByPlaceholder4.click();

        WebElement inputElementByPlaceholder5 = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[1]/div[2]/div[1]/input"));
        inputElementByPlaceholder5.sendKeys("12");

        WebElement inputElementByPlaceholder6 = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[1]/div[2]/div[1]/input"));
        inputElementByPlaceholder5.sendKeys("12");

        WebElement inputElementByPlaceholder7 = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[1]/div[1]/div[2]/div/select"));
        inputElementByPlaceholder7.click();

        WebElement inputElementByPlaceholder8 = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[1]/div[1]/div[2]/div/select/option[3]"));
        inputElementByPlaceholder8.click();

        WebElement inputElementByPlaceholder9 = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[1]/div[2]/div[2]/input"));
        inputElementByPlaceholder9.sendKeys("1200");

        WebElement inputElementByPlaceholder10 = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[1]/div[1]/div[4]/select"));
        inputElementByPlaceholder10.click();

        WebElement inputElementByPlaceholder11 = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[1]/div[1]/div[4]/select/option[2]"));
        inputElementByPlaceholder11.click();

        WebElement inputElementByPlaceholder12 = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[1]/div[2]/div[3]/select"));
        inputElementByPlaceholder12.click();

        WebElement inputElementByPlaceholder13 = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[1]/div[2]/div[3]/select/option[1]"));
        inputElementByPlaceholder13.click();

        WebElement inputElementByPlaceholder14 = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[1]/div[2]/div[4]/input"));
        inputElementByPlaceholder14.sendKeys("10");

        WebElement inputElementByPlaceholder15 = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[1]/div[1]/div[3]/select"));
        inputElementByPlaceholder15.click();

        WebElement inputElementByPlaceholder16 = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[1]/div[1]/div[3]/select/option[2]"));
        inputElementByPlaceholder16.click();


        WebElement result = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[1]/div[2]/div[3]/div")));
        assert result.getText().trim().equals("Tipo de plano é obrigatório.");
        driver.quit();
    }

    /*
    * Teste de erro ao criar turma sem esporte informado
    * dado que:
    * - o usuário está logado
    * - o usuário está na página de turmas
    * quando:
    * - o usuário preenche e passa o campo de esporte vazio
    * então:
    * - o sistema exibe uma mensagem de erro
    * - o botão de criar é desabilitado
     */
    @Test
    public void testeErroCriarTurma_Sem_Esporte(){
        System.setProperty("webdriver.chorme.driver","C:\\Users\\vizzo\\Downloads\\chromedriver-win64\\chromedriver-win64\\");
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:4200/login");
        driver.manage().window().maximize();

        WebElement inputElementByPlaceholder = driver.findElement(By.xpath("/html/body/app-root/app-login/div/div[2]/div[1]/input"));
        inputElementByPlaceholder.sendKeys("admin");
        WebElement inputElementByPlaceholder2 = driver.findElement(By.xpath("/html/body/app-root/app-login/div/div[2]/div[2]/div[1]/input"));
        inputElementByPlaceholder2.sendKeys("123");
        WebElement entrar = driver.findElement(By.xpath("/html/body/app-root/app-login/div/div[2]/button"));
        entrar.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

        WebElement turmasButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/app-header/header/div/div/ul/li[4]/a")));
        turmasButton.click();
        WebElement botaoAdicionar = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/app-admin-courses/div/div[1]/div/app-course-modal/div/button")));
        botaoAdicionar.click();

        WebElement inputElementByPlaceholder3 = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[1]/div[1]/div[1]/select"));
        inputElementByPlaceholder3.click();

        WebElement inputElementByPlaceholder4 = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[1]/div[1]/div[1]/select/option[2]"));
        inputElementByPlaceholder4.click();

        WebElement inputElementByPlaceholder5 = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[1]/div[2]/div[1]/input"));
        inputElementByPlaceholder5.sendKeys("12");

        WebElement inputElementByPlaceholder6 = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[1]/div[2]/div[1]/input"));
        inputElementByPlaceholder5.sendKeys("12");

        WebElement inputElementByPlaceholder7 = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[1]/div[1]/div[2]/div/select"));
        inputElementByPlaceholder7.click();

        WebElement inputElementByPlaceholder8 = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[1]/div[1]/div[2]/div/select/option[3]"));
        inputElementByPlaceholder8.click();

        WebElement inputElementByPlaceholder9 = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[1]/div[2]/div[2]/input"));
        inputElementByPlaceholder9.sendKeys("1200");

        WebElement inputElementByPlaceholder10 = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[1]/div[1]/div[4]/select"));
        inputElementByPlaceholder10.click();

        WebElement inputElementByPlaceholder11 = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[1]/div[1]/div[4]/select/option[2]"));
        inputElementByPlaceholder11.click();

        WebElement inputElementByPlaceholder15 = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[1]/div[1]/div[3]/select"));
        inputElementByPlaceholder15.click();

        WebElement inputElementByPlaceholder16 = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[1]/div[1]/div[3]/select/option[1]"));
        inputElementByPlaceholder16.click();

        WebElement inputElementByPlaceholder13 = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[1]/div[2]/div[3]/select/option[1]"));
        inputElementByPlaceholder13.click();

        WebElement inputElementByPlaceholder14 = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[1]/div[2]/div[4]/input"));
        inputElementByPlaceholder14.sendKeys("10");

        WebElement inputElementByPlaceholder12 = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[1]/div[2]/div[3]/select"));
        inputElementByPlaceholder12.click();


        WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/form/div[1]/div[1]/div[3]/div")));
        assert result.getText().trim().equals("Esporte é obrigatório.");

        driver.quit();
    }


    public static String gerarEmail() {
        String[] dominios = {"@gmail.com", "@outlook.com", "@bol.com.br"};
        Random random = new Random();

            String nome = "teste";

            String cpfAleatorio = gerarCpfAleatorio();

            String dominio = dominios[random.nextInt(dominios.length)];

            String email = nome + cpfAleatorio + dominio;

            return email;
    }

    private static String gerarCpfAleatorio() {
        Random random = new Random();
        StringBuilder cpf = new StringBuilder();
        for (int i = 0; i < 11; i++) {
            cpf.append(random.nextInt(10));
        }
        return cpf.toString();
    }

    private static String gerarnumAleatorio() {
        Random random = new Random();
        StringBuilder cpf = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            cpf.append(random.nextInt(10));
        }
        return cpf.toString();
    }

    private static String gerarNumeroTelefone() {
        var prefix = new String[]{"11", "12", "13", "14", "15", "16", "17", "18", "19"};
        var random = new Random();
        return prefix[random.nextInt(prefix.length)] + "9" + gerarnumAleatorio();
    }
}
