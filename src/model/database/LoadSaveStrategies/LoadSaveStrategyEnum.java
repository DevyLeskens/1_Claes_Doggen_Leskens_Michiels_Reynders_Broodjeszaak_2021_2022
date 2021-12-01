package model.database.LoadSaveStrategies;

import java.io.File;

public enum LoadSaveStrategyEnum {

    EXCEL_SANDWICH ("Excel Sandwich", "model.database.LoadSaveStrategies.SandwichExcelLoadSaveSaveStrategy", new File("src/bestanden/broodjes.xls")),
    EXCEL_TOPPING ("Excel Topping", "model.database.LoadSaveStrategies.ToppingExcelLoadSaveSaveStrategy",new File("src/bestanden/beleg.xls")),
    TEXT_SANDWICH ("Text Sandwich", "model.database.LoadSaveStrategies.SandwichesTextLoadSaveStrategy", new File("src/bestanden/broodjes.txt")),
    TEXT_TOPPING ("Text Topping", "model.database.LoadSaveStrategies.ToppingsTextLoadSaveStrategy",new File("src/bestanden/beleg.txt"));

    private final String naam;
    private final String locatie;
    private final File file;

    LoadSaveStrategyEnum(String naam, String locatie,File file) {
        this.naam = naam;
        this.locatie = locatie;
        this.file = file;
    }

    public String getNaam() { return naam; }
    public String getLocatie() { return locatie; }
    public File getFile() { return file; }
}
