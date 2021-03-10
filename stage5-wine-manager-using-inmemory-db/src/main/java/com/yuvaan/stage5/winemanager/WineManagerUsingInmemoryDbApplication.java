package com.yuvaan.stage5.winemanager;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.yuvaan.stage5.winemanager.entity.Wine;
import com.yuvaan.stage5.winemanager.service.WineService;

@SpringBootApplication
@ComponentScan
public class WineManagerUsingInmemoryDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(WineManagerUsingInmemoryDbApplication.class, args);
	}

	@Bean
	CommandLineRunner populateWineData(WineService wineService) {
		return (args) -> {
			wineService.addWine(new Wine(0, "CHATEAU DE SAINT COSME", 2009, 13.0f, "France",
					"Southern Rhone / Gigondas",
					"The aromas of fruit and spice give one a hint of the light drinkability of this lovely wine, which makes an excellent complement to fish dishes.",
					"Batch-AAA-83763637"));
			wineService.addWine(new Wine(1, "LAN RIOJA CRIANZA", 2006, 10.0f, "Spain", "Rioja",
					"A resurgence of interest in boutique vineyards has opened the door for this excellent foray into the dessert wine market. Light and bouncy, with a hint of black truffle, this wine will not fail to tickle the taste buds.",
					"Batch-ABF-82373"));
			wineService.addWine(new Wine(2, "MARGERUM SYBARITE", 2010, 13.0f, "USA", "California Central Cosat",
					"The cache of a fine Cabernet in ones wine cellar can now be replaced with a childishly playful wine bubbling over with tempting tastes of\nblack cherry and licorice. This is a taste sure to transport you back in time.",
					"Batch-AOA-83737"));
			wineService.addWine(new Wine(3, "OWEN ROE \"EX UMBRIS\"", 2009, 12.0f, "USA", "Washington",
					"A one-two punch of black pepper and jalapeno will send your senses reeling, as the orange essence snaps you back to reality. Don\"t miss\nthis award-winning taste sensation.",
					"Batch-AAA-2897363"));
			wineService.addWine(new Wine(4, "REX HILL", 2009, 14.0f, "USA", "Oregon",
					"One cannot doubt that this will be the wine served at the Hollywood award shows, because it has undeniable star power. Be the first to catch\nthe debut that everyone will be talking about tomorrow.",
					"Batch-AAA-7235636"));
			wineService.addWine(new Wine(5, "VITICCIO CLASSICO RISERVA", 2007, 13.0f, "Italy", "Tuscany",
					"Though soft and rounded in texture, the body of this wine is full and rich and oh-so-appealing. This delivery is even more impressive when one takes note of the tender tannins that leave the taste buds wholly satisfied.",
					"Batch-XAA-937372"));
			wineService.addWine(new Wine(6, "CHATEAU LE DOYENNE", 2005, 11.0f, "France", "Bordeaux",
					"Though dense and chewy, this wine does not overpower with its finely balanced depth and structure. It is a truly luxurious experience for the\nsenses.",
					"Batch-AXA-623932"));
			wineService.addWine(new Wine(7, "DOMAINE DU BOUSCAT", 2009, 10.0f, "France", "Bordeaux",
					"The light golden color of this wine belies the bright flavor it holds. A true summer wine, it begs for a picnic lunch in a sun-soaked vineyard.",
					"Batch-AAB-837647"));
			wineService.addWine(new Wine(8, "BLOCK NINE", 2009, 13.5f, "USA", "California",
					"With hints of ginger and spice, this wine makes an excellent complement to light appetizer and dessert fare for a holiday gathering.",
					"Batch-AAA"));
			wineService.addWine(new Wine(9, "DOMAINE SERENE", 2007, 13.0f, "USA", "Oregon",
					"Though subtle in its complexities, this wine is sure to please a wide range of enthusiasts. Notes of pomegranate will delight as the nutty finish completes the picture of a fine sipping experience.",
					"Batch-AAA-36357"));
			wineService.addWine(new Wine(10, "BODEGA LURTON", 2011, 12.0f, "Argentina", "Mendoza",
					"Solid notes of black currant blended with a light citrus make this wine an easy pour for varied palates.",
					"Batch-AAA283773"));
			wineService.addWine(new Wine(11, "LES MORIZOTTES", 2009, 11.0f, "France", "Burgundy",
					"Breaking the mold of the classics, this offering will surprise and undoubtedly get tongues wagging with the hints of coffee and tobacco in\nperfect alignment with more traditional notes. Breaking the mold of the classics, this offering will surprise and\nundoubtedly get tongues wagging with the hints of coffee and tobacco in\nperfect alignment with more traditional notes. Sure to please the late-night crowd with the slight jolt of adrenaline it brings.",
					"Batch-AAA"));
		};
	}

}
