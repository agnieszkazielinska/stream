package agi;

import agi.domain.*;
import agi.logic.HoldingMockGenerator;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.Currency;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.String.format;
import static java.util.stream.Collectors.*;
import static java.util.stream.Collectors.toSet;

/**
 * doczytac o:
 * flatMap
 * discount
 * count
 * peek
 * limit
 * reduce
 * entrySet
 * findFirst
 * Collectors.toMap
 * sorted
 * reversed
 * mapToInt
 * ... jeszcze jakies beda w trakcie
 * Klasa Optional
 */

class Workshop {
    /**
     * Lista holdingów wczytana z mocka.
     */
    private final List<Holding> holdings;

    Workshop() {
        final HoldingMockGenerator holdingMockGenerator = new HoldingMockGenerator();
        holdings = holdingMockGenerator.generate();
    }

    /**
     * Metoda zwraca liczbę holdingów w których jest przynajmniej jedna firma.
     */
    long getHoldingsWhereAreCompanies() {
        return holdings.stream()
                .filter(h -> h.getCompanies().size() > 1)
                .count();
    }

    /**
     * Zwraca nazwy wszystkich holdingów pisane z małej litery w formie listy.
     */
    List<String> getHoldingNames() {
        return holdings.stream()
                .map(h -> h.getName().toLowerCase(Locale.ROOT))
                .collect(Collectors.toList());
    }

    /**
     * Zwraca nazwy wszystkich holdingów sklejone w jeden string i posortowane.
     * String ma postać: (Coca-Cola, Nestle, Pepsico)
     */
    String getHoldingNamesAsString() {
        List<String> nameList = holdings.stream()
                .map(h -> h.getName())
                .sorted()
                .collect(Collectors.toList());

        String result = "(";

        for (int i = 0; i < nameList.size(); i++) {
            if (nameList.size() - 1 != i) {
                result = result.concat(nameList.get(i)).concat(", ");
            }
        }

        result = result.concat(")");

        return result;

        //TODO: zrobic to w jendym streamie, zgooglowac jak zrobic stringa z elementow listy String
    }

    /**
     * Zwraca liczbę firm we wszystkich holdingach.
     */
    long getCompaniesAmount() {
        List<Company> list = holdings.stream()
                .map(h -> h.getCompanies())
                .flatMap(h -> h.stream())
                .collect(Collectors.toList());

        return list.stream()
                .distinct()
                .count();
    }

    /**
     * Zwraca liczbę wszystkich pracowników we wszystkich firmach.
     */
    long getAllUserAmount() {

    }

    /**
     * Zwraca listę wszystkich nazw firm w formie listy. Tworzenie strumienia firm umieść w osobnej metodzie którą
     * później będziesz wykorzystywać.
     */
    List<String> getAllCompaniesNames() {

    }

    /**
     * Zwraca listę wszystkich firm jako listę, której implementacja to LinkedList. Obiektów nie przepisujemy
     * po zakończeniu działania strumienia.
     */
    LinkedList<String> getAllCompaniesNamesAsLinkedList() {

    }

    /**
     * Zwraca listę firm jako String gdzie poszczególne firmy są oddzielone od siebie znakiem "+"
     */
    String getAllCompaniesNamesAsString() {

    }

    /**
     * Zwraca listę firm jako string gdzie poszczególne firmy są oddzielone od siebie znakiem "+".
     * Używamy collect i StringBuilder.
     * <p>
     * UWAGA: Zadanie z gwiazdką. Nie używamy zmiennych.
     */
    String getAllCompaniesNamesAsStringUsingStringBuilder() {

    }

    /**
     * Zwraca liczbę wszystkich rachunków, użytkowników we wszystkich firmach.
     */
    long getAllUserAccountsAmount() {

    }

    /**
     * Zwraca listę wszystkich walut w jakich są rachunki jako string, w którym wartości
     * występują bez powtórzeń i są posortowane.
     */
    String getAllCurrencies() {

    }

    /**
     * Metoda zwraca analogiczne dane jak getAllCurrencies, jednak na utworzonym zbiorze nie uruchamiaj metody
     * stream, tylko skorzystaj z  Stream.generate. Wspólny kod wynieś do osobnej metody.
     *
     * @see #getAllCurrencies()
     */
    String getAllCurrenciesUsingGenerate() {

    }

    private List<String> getAllCurrenciesToListAsString() {

    }

    /**
     * Zwraca liczbę kobiet we wszystkich firmach. Powtarzający się fragment kodu tworzący strumień użytkowników umieść
     * w osobnej metodzie. Predicate określający czy mamy do czynienia z kobietą niech będzie polem statycznym w klasie.
     */
    long getWomanAmount() {

    }


    /**
     * Przelicza kwotę na rachunku na złotówki za pomocą kursu określonego w enum Currency.
     */
    BigDecimal getAccountAmountInPLN(final Account account) {

    }

    /**
     * Przelicza kwotę na podanych rachunkach na złotówki za pomocą kursu określonego w enum Currency i sumuje ją.
     */
    BigDecimal getTotalCashInPLN(final List<Account> accounts) {

    }

    /**
     * Zwraca imiona użytkowników w formie zbioru, którzy spełniają podany warunek.
     */
    Set<String> getUsersForPredicate(final Predicate<User> userPredicate) {

    }

    /**
     * Metoda filtruje użytkowników starszych niż podany jako parametr wiek, wyświetla ich na konsoli, odrzuca mężczyzn
     * i zwraca ich imiona w formie listy.
     */
    List<String> getOldWoman(final int age) {

    }

    /**
     * Dla każdej firmy uruchamia przekazaną metodę.
     */
    void executeForEachCompany(final Consumer<Company> consumer) {
    }

    /**
     * Wyszukuje najbogatsza kobietę i zwraca ją. Metoda musi uzwględniać to że rachunki są w różnych walutach.
     */
    //pomoc w rozwiązaniu problemu w zadaniu: https://stackoverflow.com/a/55052733/9360524
    Optional<User> getRichestWoman() {

    }

    private BigDecimal getUserAmountInPLN(final User user) {

    }

    /**
     * Zwraca nazwy pierwszych N firm. Kolejność nie ma znaczenia.
     */
    Set<String> getFirstNCompany(final int n) {

    }

    /**
     * Metoda zwraca jaki rodzaj rachunku jest najpopularniejszy. Stwórz pomocniczą metodę getAccountStream.
     * Jeżeli nie udało się znaleźć najpopularniejszego rachunku metoda ma wyrzucić wyjątek IllegalStateException.
     * Pierwsza instrukcja metody to return.
     */
    AccountType getMostPopularAccountType() {

    }

    /**
     * Zwraca pierwszego z brzegu użytkownika dla podanego warunku. W przypadku kiedy nie znajdzie użytkownika wyrzuca
     * wyjątek IllegalArgumentException.
     */
    User getUser(final Predicate<User> predicate) {

    }

    /**
     * Zwraca mapę firm, gdzie kluczem jest jej nazwa a wartością lista pracowników.
     */
    Map<String, List<User>> getUserPerCompany() {

    }


    /**
     * Zwraca mapę firm, gdzie kluczem jest jej nazwa a wartością lista pracowników przechowywanych jako String
     * składający się z imienia i nazwiska. Podpowiedź:  Możesz skorzystać z metody entrySet.
     */
    Map<String, List<String>> getUserPerCompanyAsString() {

    }

    /**
     * Zwraca mapę firm, gdzie kluczem jest jej nazwa a wartością lista pracowników przechowywanych jako obiekty
     * typu T, tworzonych za pomocą przekazanej funkcji.
     */
    //pomoc w rozwiązaniu problemu w zadaniu: https://stackoverflow.com/a/54969615/9360524
    <T> Map<String, List<T>> getUserPerCompany(final Function<User, T> converter) {

    }

    /**
     * Zwraca mapę gdzie kluczem jest flaga mówiąca o tym czy mamy do czynienia z mężczyzną, czy z kobietą.
     * Osoby "innej" płci mają zostać zignorowane. Wartością jest natomiast zbiór nazwisk tych osób.
     */
    Map<Boolean, Set<String>> getUserBySex() {

    }

    /**
     * Zwraca mapę rachunków, gdzie kluczem jest numer rachunku, a wartością ten rachunek.
     */
    Map<String, Account> createAccountsMap() {

    }

    /**
     * Zwraca listę wszystkich imion w postaci Stringa, gdzie imiona oddzielone są spacją i nie zawierają powtórzeń.
     */
    String getUserNames() {

    }

    /**
     * Zwraca zbiór wszystkich użytkowników. Jeżeli jest ich więcej niż 10 to obcina ich ilość do 10.
     */
    Set<User> getUsers() {

    }

    /**
     * Zapisuje listę numerów rachunków w pliku na dysku, gdzie w każda linijka wygląda następująco:
     * NUMER_RACHUNKU|KWOTA|WALUTA
     * <p>
     * Skorzystaj z strumieni i try-resources.
     */
    void saveAccountsInFile(final String fileName) {

    }

    /**
     * Zwraca użytkownika, który spełnia podany warunek.
     */
    Optional<User> findUser(final Predicate<User> userPredicate) {

    }

    /**
     * Dla podanego użytkownika zwraca informacje o tym ile ma lat w formie:
     * IMIE NAZWISKO ma lat X. Jeżeli użytkownik nie istnieje to zwraca text: Brak użytkownika.
     * <p>
     * Uwaga: W prawdziwym kodzie nie przekazuj Optionali jako parametrów.
     */
    String getAdultantStatus(final Optional<User> user) {

    }

    /**
     * Metoda wypisuje na ekranie wszystkich użytkowników (imię, nazwisko) posortowanych od z do a.
     * Zosia Psikuta, Zenon Kucowski, Zenek Jawowy ... Alfred Pasibrzuch, Adam Wojcik
     */
    void showAllUser() {

    }

    /**
     * Zwraca mapę, gdzie kluczem jest typ rachunku a wartością kwota wszystkich środków na rachunkach tego typu
     * przeliczona na złotówki.
     */

    Map<AccountType, BigDecimal> getMoneyOnAccounts() {

    }

    /**
     * Zwraca sumę kwadratów wieków wszystkich użytkowników.
     */
    int getAgeSquaresSum() {

    }

    /**
     * Metoda zwraca N losowych użytkowników (liczba jest stała). Skorzystaj z metody generate. Użytkownicy nie mogą się
     * powtarzać, wszystkie zmienną muszą być final. Jeżeli podano liczbę większą niż liczba użytkowników należy
     * wyrzucić wyjątek (bez zmiany sygnatury metody).
     */
    List<User> getRandomUsers(final int n) {

    }

    /**
     * Zwraca strumień wszystkich firm.
     */
    private Stream<Company> getCompanyStream() {

    }

    /**
     * Zwraca zbiór walut w jakich są rachunki.
     */
    private Set<Currency> getCurenciesSet() {

    }

    /**
     * Tworzy strumień rachunków.
     */
    private Stream<Account> getAccoutStream() {

    }

    /**
     * Tworzy strumień użytkowników.
     */
    private Stream<User> getUserStream() {

    }

    /**
     * 38.
     * Stwórz mapę gdzie kluczem jest typ rachunku a wartością mapa mężczyzn posiadających ten rachunek, gdzie kluczem
     * jest obiekt User a wartością suma pieniędzy na rachunku danego typu przeliczona na złotkówki.
     */

    Map<Stream<AccountType>, Map<User, BigDecimal>> getMapWithAccountTypeKeyAndSumMoneyForManInPLN() {

    }

    private Map<User, BigDecimal> manWithSumMoneyOnAccounts(final Company company) {

    }

    private BigDecimal getSumUserAmountInPLN(final User user) {

    }

    /**
     * 39. Policz ile pieniędzy w złotówkach jest na kontach osób które nie są ani kobietą ani mężczyzną.
     */
    BigDecimal getSumMoneyOnAccountsForPeopleOtherInPLN() {

    }

    /**
     * 40. Wymyśl treść polecenia i je zaimplementuj.
     * Policz ile osób pełnoletnich posiada rachunek oraz ile osób niepełnoletnich posiada rachunek. Zwróć mapę
     * przyjmując klucz True dla osób pełnoletnich i klucz False dla osób niepełnoletnich. Osoba pełnoletnia to osoba
     * która ma więcej lub równo 18 lat
     */
    Map<Boolean, Long> divideIntoAdultsAndNonAdults() {
        return null;
    }
}
