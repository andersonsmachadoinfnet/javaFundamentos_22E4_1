package br.anderson.infnet.appclinica.model.auxiliar;

import java.util.Random;
import java.time.LocalDate;

public class Faker {
	public static final String[] _NOMES_ = 
		{"JOSE","JOAO","ANTONIO","FRANCISCO","CARLOS",
		 "MARIA","ANA","ANTONIA","ADRIANA","JULIANA"};
	
	public static final String[] _SOBRENOMES_ = 
		{"SILVA","SANTOS","OLIVEIRA","SOUZA","RODRIGUES",
         "FERREIA","ALVES","PEREIRA","LIMA","GOMES"};
	
	public static final String[] _CPFS_  = 
		{"566.101.340-06","918.959.560-21","996.308.270-00",
		 "179.888.440-24","038.446.510-20","588.034.670-68",
		 "561.867.600-14","438.131.340-24","219.662.460-80",
		 "964.230.710-39"};
	
	public static final String[] _EXAMES_ = 
		{"Hemograma","Glicemia em jejum","Colesterol","Triglicerídeos",
		 "Ureia","Creatinina","TGO (AST)", "TGP (ALT)",
         "TSH","T4 Livre","Ácido úrico","Exame de urina",
         "Eletrocardiograma","Ecocardiograma","Papanicolau",
         "Mamografia","PSA"};
	
	public static final String[] _CIRURGIAS_ = 
		{"Hérnia umbilical","Hérnia inguinal","Hidrocele",
		 "Fimose","Criptorquidia","Hipospádia",
         "Timpanoplastia","Estapedectomia","Mastoidectomia",
         "Adenóide","Rinoplastia"};
	
	// Lista de palavras obtidas em https://www.lipsum.com/feed/html
	public static final String[] _PALAVRAS_ =
		{"Lorem","ipsum","dolor","sit","amet,","consectetur",
		 "adipiscing","elit.","Pellentesque","luctus,","magna",
		 "et","tincidunt","placerat,","magna","nisl","tristique",
		 "sapien,","ac","commodo","magna","enim","ac","velit.",
		 "Nam","et","diam","sapien.","Proin","iaculis,","tortor",
		 "a","laoreet","lobortis,","diam","odio","molestie","leo,",
		 "vel","vestibulum","metus","turpis","id","diam.","Curabitur",
		 "bibendum","ultrices","lacus,","sed","scelerisque",
		 "urna","dignissim","vulputate.","Maecenas","eu","leo",
		 "felis.","Integer","at","urna","in","mauris","volutpat",
		 "ornare","nec","non","ex.","Vestibulum","porta","est",
		 "sed","ullamcorper","tristique.","Vivamus","dignissim",
		 "laoreet","mi","at","aliquam.","Quisque","leo","risus,",
		 "efficitur","quis","arcu","id,","ultrices","vehicula",
		 "velit.","Duis","quis","lectus","venenatis,","mollis",
		 "nulla","ac,","dignissim","dolor.","Nunc","euismod",
		 "magna","sit","amet","tortor","venenatis,","at",
		 "mattis","ex","fermentum.","Vestibulum","finibus,",
		 "est","vel","molestie","mattis,","nisi","arcu",
		 "faucibus","elit,","in","pharetra","nulla","mauris",
		 "in","sapien.","Etiam","sed","maximus","justo,","eget",
		 "ultricies","nisi.","Vestibulum","ac","lacus","vitae",
		 "augue","tristique","ullamcorper.","Nulla","vehicula",
		 "finibus","nibh","ut","fermentum.","Pellentesque","interdum,",
		 "nibh","quis","bibendum","volutpat,","nisi","nisi","malesuada",
		 "nisi,","et","pharetra","ante","nunc","in","tellus.","Proin",
		 "enim","sem,","posuere","sed","suscipit","id,","posuere","sed",
		 "lectus.","Sed","dapibus","eget","eros","ac","facilisis.","Vestibulum",
		 "id","pulvinar","diam.","Pellentesque","vehicula","in","leo","nec",
		 "euismod.","Proin","egestas","est","mauris,","ut","lobortis",
		 "neque","tempor","in.","Lorem","ipsum","dolor","sit","amet,",
		 "consectetur","adipiscing","elit.","Vestibulum","blandit","sem",
		 "efficitur","maximus","suscipit.","Aliquam","quis","eros","molestie,",
		 "lacinia","urna","eget,","fringilla","augue.","Nullam","urna",
		 "mauris,","finibus","eget","neque","sit","amet,","commodo",
		 "scelerisque","neque.","Nam","quis","tortor","a","lacus",
		 "egestas","tempus.","Maecenas","commodo","fringilla","lacus",
		 "nec","ornare.","Mauris","eu","luctus","arcu,","in","commodo",
		 "elit.","Nunc","eu","urna","sem.","Mauris","blandit","magna",
		 "sit","amet","odio","sagittis,","nec","mattis","erat","posuere.",
		 "Morbi","mattis","nulla","id","libero","sollicitudin,","in",
		 "luctus","dolor","euismod.","Vivamus","vel","mattis","magna.",
		 "Curabitur","nec","ligula","a","metus","elementum","pulvinar.",
		 "In","hac","habitasse","platea","dictumst.","Nulla",
		 "ullamcorper,","sapien","vel","porttitor","semper,",
		 "lacus","arcu","interdum","sapien,","in","suscipit",
		 "mi","dui","fermentum","leo.","Ut","commodo","enim","nec",
		 "erat","rhoncus","placerat.","Praesent","felis","diam,",
		 "placerat","sed","dolor","eu,","fermentum","consequat",
		 "nisl.","Donec","tempus,","enim","sit","amet","facilisis",
		 "consectetur,","dolor","lorem","consequat","odio,","at",
		 "ornare","nisi","nunc","et","purus.","Curabitur","pretium",
		 "sagittis","neque,","et","lacinia","nisl","sollicitudin",
		 "at.","Pellentesque","aliquam","tortor","et","elit",
		 "molestie","varius.","Vivamus","vitae","ex","at","lorem",
		 "tincidunt","aliquet.","Nunc","tempor","id","quam","eu",
		 "ultrices.","Etiam","sed","auctor","odio,","nec","vehicula",
		 "mauris.","Integer","aliquet","mauris","vitae","tempus",
		 "posuere.","Quisque","nec","mattis","metus.","Aenean",
		 "eget","enim","efficitur,","sagittis","nulla"};
	
	// Lista obtida em: https://www.google.com/url?sa=t&rct=j&q=&esrc=s&source=web&cd=&ved=2ahUKEwiftu3K1e_7AhX8HbkGHVROCZkQFnoECAgQAw&url=https%3A%2F%2Fwww.campinadalagoa.pr.gov.br%2Fdocumentos%2Fcomunicado_saude%2F11.pdf&usg=AOvVaw2-OnWfcoCs82jOBCMvCJ4R
	public static final String[] _MEDICAMENTOS_ =
		{"Dobutamina 12,5mg/mL ampola 20mL – sol.injetável"
				,"Dopamina 5mg/mL ampola 10mL – sol.injetável"
				,"Epinefrina 1mg/mL ampola 1mL – sol.injetável"
				,"Etilefrina 10mg/mL ampola 1mL – sol.injetável"
				,"Norepinefrina Hemitartarato 2mg/mL ampola 4mL – sol.injetável"
				,"Amicacina 50mg/mL ampola 2mL – sol.injetável"
				,"Fentanila 0,05mg/mL frasco-ampola 10mL – sol.injetável"
				,"Morfina 10mg/mL ampola 1mL – sol.injetável"
				,"Tramadol 50mg/mL ampola 2mL – sol.injetável"
				,"Ácido acetilsalicílico 100mg -comprimido"
				,"Cetoprofeno 50mg/mL ampola 2mL – sol.injetável (IM )"
				,"Diclofenaco sódico 25 mg/mL - 3mL(75mg) - AMP"
				,"Dipirona 500mg/mL ampola 2mL – sol.injetável"
				,"Dipirona 500mg/mL frasco-gotas 20mL – sol.oral"
				,"Paracetamol 200mg/mL frasco-gotas 20mL – sol.oral"
				,"Paracetamol 750mg – comprimido"
				,"Lidocaína 20mg/g (2%) bisnaga 30g – geléia"
				,"Lidocaína 20mg/mL (2%) com vasoconstrictor frasco-ampola 20mL – sol.injetável"
				,"Lidocaína 20mg/mL (2%) sem vasoconstrictor frasco-ampola 20mL – sol.injetável"
				,"Diazepam 5mg/mL ampola 2mL – sol.injetável"
				,"Etomidato 2mg/mL ampola 10mL – sol.injetável"
				,"Flumazenil 0,1mg/mL ampola 5mL – sol.injetável"
				,"Midazolam 5mg/mL ampola 3mL – sol.injetável"
				,"Midazolam 5mg/mL ampola 10mL – sol.injetável"
				,"Diazepam 5mg – comprimido"
				,"Ácido acetilsalicílico 100mg - comprimido"
				,"Clopidogrel 75mg – comprimido"
				,"Hidroxizina 2mg/mL frasco 120mL – sol.oral"
				,"Prometazina 25mg/mL ampola 2mL – sol.injetável"
				,"Anlodipino 10mg - comprimido"
				,"Dinitrato de Isossorbida 10mg – comprimido"
				,"Dinitrato de Isossorbida 5mg – comprimido"
				,"Nitroglicerina 25mg/mL ampola 2mL – sol.injetável"
				,"Adenosina 3mg/mL ampola 2mL – sol.injetável"
				,"Amiodarona 200mg – comprimido"
				,"Amiodarona 50mg/mL ampola 3mL – sol.injetável"
				,"Carvedilol 3,125mg – comprimido"
				,"Lidocaína 20mg/mL (2%) sem vasoconstrictor frasco-ampola 20mL – sol.injetável"
				,"Propranolol 40mg - comprimido"
				,"Sulfadiazina de prata 10mg/g (1%) bisnaga 50g – creme"
				,"Enoxaparina Sódica 40mg/0,4mL seringa preenchida – sol. injetável"
				,"Fondaparinux sódico 2,5mg/0,5mL - 0,5mL- SER"
				,"Fondaparinux sódico 7,5mg/0,5mL - 0,6mL- SER"
				,"Heparina sódica endovenosa 5.000 UI/mL frasco-ampola 5mL – sol.injetável"
				,"Heparina sódica subcutânea 5.000 UI/0,25mL ampola 0,25mL – sol. injetável"
				,"Varfarina sódica 2,5mg – comprimido"
				,"Diazepam 5mg/mL ampola 2mL – sol.injetável"
				,"Fenitoína 50mg/mL ampola 5mL – sol.injetável"
				,"Fenobarbital 100mg/mL ampola 2mL – sol.injetável"
				,"Atropina 0,25mg/mL ampola 1mL – sol.injetável"
				,"Carvão ativado pó – uso oral"
				,"Fitomenadiona 10mg/mL IM ampola 1mL – sol.injetável"
				,"Naloxona 0,4mg/mL ampola 1mL – sol.injetável"
				,"Protamina 1.000UI/mL ampola 5mL – sol.injetável"
				,"Bromoprida 5mg/mL ampola 2mL – sol.injetável"
				,"Metoclopramida 5mg/mL ampola 2mL – sol.injetável"
				,"Propranolol 40mg – comprimido"
				,"Hioscina 20mg/mL ampola 1mL – sol.injetável"
				,"Hioscina 4mg/mL + Dipirona 500mg/mL ampola 5mL – sol.injetável"
				,"Hioscina 6,67mg/mL + Dipirona 333,4mg/mL frasco-gotas 20mL – sol.oral"
				,"Hioscina 10mg/mL - 20mL - Solução - Via oral - Frasco-gotas"
				,"Dimeticona 75mg/mL frasco-gotas 15mL – emulsão oral"
				,"Fluconazol 2mg/mL bolsa 100mL – sol.injetável"
				,"Anlodipino 10mg - comprimido"
				,"Captopril 25mg – comprimido"
				,"Carvedilol 3,125mg – comprimido"
				,"Clonidina 0,1mg – comprimido"
				,"Hidralazina 20mg/mL ampola 1mL – sol. injetável"
				,"Losartana 50mg – comprimido"
				,"Nitroprussiato de sódio 25mg/mL ampola 2mL – sol.injetável"
				,"Propranolol 40mg – comprimido"
				,"Aciclovir 250mg frasco-ampola – pó liofilizado"
				,"Amicacina 50mg/mL ampola 2mL – sol.injetável"
				,"Ampicilina + sulbactam 3g frasco-ampola – pó liofilizado"
				,"Azitromicina 500mg – Frasco-ampola"
				,"Benzilpenicilina Benzatina 1.200.000UI frasco-ampola – pó liofilizado (uso IM)"
				,"Benzilpenicilina Potássica 5.000.000UI frasco-ampola – pó liofilizado (uso IM/EV)"
				,"Benzilpenicilina benzatina 600.000UI - frasco-ampola – pó liofilizado"
				,"Cefazolina 1g frasco-ampola – pó liofilizado"
				,"Cefepime 1g frasco-ampola – pó liofilizado"
				,"Cefepime 2g frasco-ampola – pó liofilizado"
				,"Ceftriaxona 1g IM frasco-ampola – pó liofilizado"
				,"Ceftriaxona 1g IV frasco-ampola – pó liofilizado"
				,"Ciprofloxacina 2mg/mL bolsa 100mL – sol.injetável"
				,"Clindamicina 150mg/mL ampola 4mL – sol.injetável"
				,"Fluconazol 2mg/mL bolsa 100mL – sol.injetável"
				,"Levofloxacino 5mg/mL – bolsa 100mL – solução injetável"
				,"Meropenem 1g - Pó liofilizado - Via endovenosa - Frasco-ampola"
				,"Oxacilina 500mg frasco-ampola – pó liofilizado"
				,"Piperacilina + tazobactam 4,5g frasco-ampola – pó liofilizado"
				,"Sulfadiazina de prata 10mg/g (1%) bisnaga 50g – creme"
				,"Sulfametoxazol + Trimetoprima 400mg+80mg/5mL ampola 5mL – sol.injetável"
				,"Vancomicina 500mg frasco-ampola – pó liofilizado"
				,"Dexametasona 4mg/mL ampola 2,5mL – sol. injetável"
				,"Hidrocortisona 100mg frasco-ampola – pó liofilizado"
				,"Hidrocortisona 500mg frasco-ampola – pó liofilizado"
				,"Prednisolona 3mg/mL frasco 100mL – sol.oral"
				,"Prednisona 20mg – comprimido"
				,"Cetoprofeno 50mg/mL ampola 2mL – sol.injetável (IM )"
				,"Diclofenaco sódico 25 mg/mL - 3mL(75mg) – AMP"
				,"Metronidazol 500mg/100mL bolsa – sol.injetável"
				,"Cetilpiridínio frasco 250mL – enxaguatório bucal"
				,"Clorexidina (gluconato) 0,12% frasco 1L – enxaguatório bucal (periogard)"
				,"Aciclovir 250mg frasco-ampola – pó liofilizado"
				,"Aminofilina 24mg/mL ampola 10mL – sol.injetável"
				,"Fenoterol 5mg/mL frasco-gotas 20mL– uso inalatório"
				,"Ipratrópio (brometo) 0,25mg/mL frasco 20mL – uso inalatório"
				,"Salbutamol (sulfato) 100mcg/dose - 200 doses – Solução inalatória - Via oral de inalação –"
				,"Frasco-spray"
				,"Terbutalina 0,5mg/mL ampola 1mL – sol.injetável"
				,"Suxametônio 100mg frasco-ampola – pó liofilizado"
				,"Meropenem 1g frasco"
				,"Cefazolina 1g frasco-ampola – pó liofilizado"
				,"Ceftriaxona 1g IM frasco"
				,"Ceftriaxona 1g IV frasco"
				,"Cefepime 1g frasco"
				,"Cefepime 2g frasco"
				,"Cloreto de sódio 20% ampola 10mL – solução injetável"
				,"Furosemida 10mg/mL ampola 2mL – solução injetável"
				,"Hidroclorotiazida 25mg – comprimido"
				,"Digoxina 0,25 mg – comprimido"
				,"Ácido tranexâmico 50mg/mL ampola 5mL – solução injetável"
				,"Fitomenadiona 10mg/mL IM ampola 1mL – solução injetável"
				,"Sinvastatina 40mg – comprimido"
				,"Deslanosídeo 0,2mg/mL ampola 2mL – solução injetável"
				,"Vancomicina 500mg frasco-ampola – pó liofilizado"
				,"Insulina NPH Humana 100UI/mL frasco"
				,"Insulina Regular Humana 100 UI/mL frasco"
				,"Lactulose 667mg/mL frasco 120mL – xarope"
				,"Clindamicina 150mg/mL ampola 4mL – solução injetável"
				,"Azitromicina 500mg – FA"
				,"Clorpromazina 5mg/mL ampola 5mL – solução injetável"
				,"Haloperidol 5mg/mL ampola 1mL – solução injetável"
				,"Ampicilina + sulbactam 3g frasco-ampola – pó liofilizado"
				,"Benzilpenicilina Benzatina 1.200.000UI frasco-ampola – pó liofilizado (uso IM)"
				,"Benzilpenicilina Potássica 5.000.000UI frasco-ampola – pó liofilizado (uso IM/EV)"
				,"Benzilpenicilina benzatina 600.000UI - frasco-ampola – pó liofilizado"
				,"Oxacilina 500mg frasco-ampola – pó liofilizado"
				,"Piperacilina + tazobactam 4,5g frasco-ampola – pó liofilizado"
				,"Ciprofloxacina 2mg/mL bolsa 100mL – solução injetável"
				,"Levofloxacino 5mg/mL – bolsa 100mL – solução injetável"
				,"Omeprazol 40mg frasco-ampola – pó liofilizado"
				,"Ranitidina 25mg/mL ampola 2mL – solução injetável"
				,"Bicarbonato de sódio 8,4% ampola 10mL – sol.injetável"
				,"Cloreto de potássio 10% ampola 10mL – solução injetável"
				,"Cloreto de sódio 20% ampola 10mL – solução injetável"
				,"Gluconato de cálcio 10% ampola 10mL – solução injetável"
				,"Sais para reidratação oral envelope 27,9g – uso oral"
				,"Poliestirenossulfonato de cálcio 900mg/g envelope 30g – uso oral"
				,"Água destilada 10mL - Ampola"
				,"Água destilada frasco 500mL – sistema fechado"
				,"Cloreto de sódio 20% ampola 10mL – solução injetável"
				,"Glicose 50% ampola 10mL – solução injetável"
				,"Solução de frutose 5% frasco 500mL – sistema fechado"
				,"Solução de glicerina 12% tubo 500mL – uso retal"
				,"Solução de glicose 5% frasco 250mL – sistema fechado"
				,"Solução de glicose 5% frasco 500mL – sistema fechado"
				,"Solução de manitol 20% frasco 250mL – sistema fechado"
				,"Solução de ringer lactato frasco 500mL – sistema fechado"
				,"Solução fisiológica 0,9% ampola 10mL – solução injetável"
				,"Solução fisiológica 0,9% frasco 100mL – sistema fechado"
				,"Solução fisiológica 0,9% frasco 250mL – sistema fechado"
				,"Solução fisiológica 0,9% frasco 500mL – sistema fechado"
				,"Solução fisiológica 0,9% frasco 1000mL – sistema fechado"
				,"Solução glicofisiológica 1:1 frasco 500mL – sistema fechado"
				,"Sulfametoxazol + Trimetoprima 400mg+80mg/5mL ampola 5mL – solução injetável"
				,"Sulfadiazina de prata 10mg/g (1%) bisnaga 50g – creme"
				,"Fitomenadiona 10mg/mL IM ampola 1mL – solução injetável"
				,"Vitaminas do complexo B ampola 2mL – solução injetável"};

	public static final String getNome() {
		return 
			String.format("%s %s %s", _NOMES_[new Random().nextInt(_NOMES_.length)],
					                  _SOBRENOMES_[new Random().nextInt(_SOBRENOMES_.length)],
					                  _SOBRENOMES_[new Random().nextInt(_SOBRENOMES_.length)]);
	}
	
	public static final String getCPF() {
		return _CPFS_[new Random().nextInt(_CPFS_.length)];
	}
	
	public static final LocalDate getDtNasc() {
		return LocalDate.of(1970+(new Random().nextInt(100)), 
				            new Random().nextInt(12)+1, 
				            new Random().nextInt(28)+1);
	}
	
	public static final String getEmail(String pNome) {
		if (pNome == null) {
			pNome = getNome();
		}
		return 
			String.format("%s%d@gmail.com", 
					      pNome,
					      new Random().nextInt(100)
					     ).replace(' ', '_');
	}
	
	public static final String getEXAME() {
		return _EXAMES_[new Random().nextInt(_EXAMES_.length)];
	}
	
	public static final String getCIRURGIA() {
		return _CIRURGIAS_[new Random().nextInt(_CIRURGIAS_.length)];
	}
	
	public static final String getMEDICAMENTO() {
		return _MEDICAMENTOS_[new Random().nextInt(_MEDICAMENTOS_.length)];
	}
	
	public static final float getVALOR() {
		return (float) (new Random().nextInt(100000)/100);
	}
	
	public static final String getTEXTO() {
		int           lQtd = new Random().nextInt(25);
		StringBuilder sb   = new StringBuilder();
		if (lQtd<3) {
			lQtd = 3;
		}
		for (int i=0;i<lQtd;i++) {
			sb.append(_PALAVRAS_[new Random().nextInt(_PALAVRAS_.length)]);
		}
		return sb.toString().trim();
	}
}
