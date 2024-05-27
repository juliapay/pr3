package at.campus02.pr3.FILEIO.abschlussbeispiel;

public class Angabe {
    /*
    File IO - Beispiel 1 – Adressbuch
Schreiben Sie ein Programm zur Verwaltung von Adressen. Das Programm soll Adressen von einer
Datei lesen können, Adressen bearbeiten können und Adressen wieder in einer Datei speichern. Zur
Vereinfachung können Sie die beiden Ergänzungen nicht implementieren.
1. Schreiben Sie eine Klasse Address mit folgenden Attributen
▪ String firstname
▪ String lastname
▪ String mobilNumber
▪ String email
Implementieren Sie einen Konstruktor, sowie getter und setter-Methoden für die Attribute.

2. Schreiben Sie eine Klasse AddressManager. Die Klasse hält in einer privaten Liste mehrere
Adressen und stellt diese Liste über eine öffentliche getter-Methode an externe Klassen zur
Verfügung. Implementieren Sie folgende Methoden:

public void add(Address a)
Diese Methode fügt eine weitere Adresse in die Liste hinzu.

public void exportToCsv(String path, String separator) throws AddressExportException
Die Methode persistiert (mittels der kennengelernten Writer-Klassen) alle in der Liste
abgelegten Adressen und speichert diese mit dem gegebenen Separator in eine
Textdatei. Im Fehlerfall soll eine AddressExportException geworfen werden.
Ergänzung: Wenn die gegebene Datei bereits existiert, soll eine eigene Exception
„AddressExportFileAlreadyExistsException“ werden.

public void loadFromCsv(String path, String separator) throws AddressLoadException
Diese Methode lädt (mittels der kennengelernten Reader-Klassen) eine Csv-Datei, welche
Adress-Daten in folgenden Format zur Verfügung stellt.
firstname;lastname;mobilenumber;email Das Trennzeichen (zwischen zwei Werten) kann
ein beliebiger Separator (z.B.: ein Beistrich, ein Semikolon, ein Pipe, usw.) sein und wird als
Parameter übernommen.
Die Methode lädt alle Adressen und legt diese in der lokalen Liste ab. Im Fehlerfall
soll eine eigene AddressLoadException geworfen werden.
Ergänzung: Überprüfen Sie, ob die eingelesene Zeile 4 Spalten enthält. Werfen Sie im
Fehlerfall eine AddressLoadWrongFormatException
Überprüfen Sie die Funktionalität mit einer Demo-Klasse.
     */
}
