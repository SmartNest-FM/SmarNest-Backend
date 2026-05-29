package com.smartnest.SmartNest.config;

import com.smartnest.SmartNest.model.*;
import com.smartnest.SmartNest.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataSeeder implements CommandLineRunner {

    private final LevelRepository levelRepository;
    private final PhonologicalAwarenessRepository phonologicalAwarenessRepository;
    private final FluentReadingRepository fluentReadingRepository;
    private final ReadingComprehensionRepository readingComprehensionRepository;
    private final CombinationReadingImagesRepository combinationReadingImagesRepository;
    private final VocabularyVerbRepository vocabularyVerbRepository;
    private final FeedbackRepository feedbackRepository;

    public DataSeeder(LevelRepository levelRepository,
                      PhonologicalAwarenessRepository phonologicalAwarenessRepository,
                      FluentReadingRepository fluentReadingRepository,
                      ReadingComprehensionRepository readingComprehensionRepository,
                      CombinationReadingImagesRepository combinationReadingImagesRepository,
                      VocabularyVerbRepository vocabularyVerbRepository,
                      FeedbackRepository feedbackRepository) {
        this.levelRepository = levelRepository;
        this.phonologicalAwarenessRepository = phonologicalAwarenessRepository;
        this.fluentReadingRepository = fluentReadingRepository;
        this.readingComprehensionRepository = readingComprehensionRepository;
        this.combinationReadingImagesRepository = combinationReadingImagesRepository;
        this.vocabularyVerbRepository = vocabularyVerbRepository;
        this.feedbackRepository = feedbackRepository;
    }

    @Override
    public void run(String... args) {
        seedLevels();
        seedPhonologicalAwareness();
        seedFluentReading();
        seedReadingComprehension();
        seedCombinationReadingImages();
        seedVocabularyVerb();
    }

    // ─── NIVELES ────────────────────────────────────────────────────────────────

    private void seedLevels() {
        if (levelRepository.count() > 0) return;

        List<Object[]> data = List.of(
            new Object[]{1, "Nivel 1", 0, "https://cdn-icons-png.flaticon.com/512/4262/4262616.png"},
            new Object[]{2, "Nivel 2", 0, "https://cdn-icons-png.flaticon.com/512/4262/4262627.png"},
            new Object[]{3, "Nivel 3", 0, "https://cdn-icons-png.flaticon.com/512/4262/4262638.png"},
            new Object[]{4, "Nivel 4", 0, "https://cdn-icons-png.flaticon.com/512/4262/4262652.png"},
            new Object[]{5, "Nivel 5", 0, "https://cdn-icons-png.flaticon.com/512/8989/8989458.png"}
        );

        for (Object[] row : data) {
            Level l = new Level();
            l.setId((int) row[0]);
            l.setName((String) row[1]);
            l.setPercentage((int) row[2]);
            l.setUrlImg((String) row[3]);
            levelRepository.save(l);
        }
    }

    // ─── NIVEL 1: PHONOLOGICAL AWARENESS ────────────────────────────────────────

    private void seedPhonologicalAwareness() {
        if (phonologicalAwarenessRepository.count() > 0) return;

        Level level1 = levelRepository.findById(1).orElseThrow();

        List<Object[]> data = List.of(
            new Object[]{1, "https://cdn-icons-png.flaticon.com/512/1998/1998592.png", "Mira la imagen. ¿Qué animal es este?", "Gato", "Gato", "Pato", "Rato"},
            new Object[]{2, "https://cdn-icons-png.flaticon.com/128/1998/1998627.png", "Mira la imagen. ¿Qué animal es este?", "Perro", "Perro", "Gato", "Lobo"},
            new Object[]{3, "https://cdn-icons-png.flaticon.com/512/6789/6789517.png", "Mira la imagen. ¿Qué animal es este?", "Pez", "Pez", "Oso", "Pato"},
            new Object[]{4, "https://cdn-icons-png.flaticon.com/512/15707/15707412.png", "Mira la imagen. ¿Qué animal es este?", "León", "León", "Oso", "Lobo"},
            new Object[]{5, "https://cdn-icons-png.flaticon.com/512/604/604192.png", "Mira la imagen. ¿Qué fruta es esta?", "Pera", "Pera", "Uva", "Piña"},
            new Object[]{6, "https://cdn-icons-png.flaticon.com/512/1412/1412542.png", "Mira la imagen. ¿Qué fruta es esta?", "Uva", "Uva", "Pera", "Fresa"},
            new Object[]{7, "https://cdn-icons-png.flaticon.com/512/5497/5497803.png", "Mira la imagen. ¿Qué objeto es este?", "Taza", "Taza", "Vaso", "Plato"},
            new Object[]{8, "https://cdn-icons-png.flaticon.com/512/607/607069.png", "Mira la imagen. ¿Qué objeto es este?", "Mesa", "Mesa", "Silla", "Cama"},
            new Object[]{9, "https://cdn-icons-png.flaticon.com/512/2866/2866099.png", "Mira la imagen. ¿Qué parte del cuerpo es esta?", "Mano", "Mano", "Nariz", "Oreja"},
            new Object[]{10, "https://cdn-icons-png.flaticon.com/512/1973/1973984.png", "Mira la imagen. ¿Qué vehículo es este?", "Tren", "Tren", "Bus", "Auto"}
        );

        for (Object[] row : data) {
            PhonologicalAwareness p = new PhonologicalAwareness();
            p.setId((int) row[0]);
            p.setMainImage((String) row[1]);
            p.setQuestion((String) row[2]);
            p.setCorrectAnswer((String) row[3]);
            p.setAnswerOne((String) row[4]);
            p.setAnswerTwo((String) row[5]);
            p.setAnswerThree((String) row[6]);
            p.setUserResponse("");
            p.setCorrect(false);
            p.setLevel(level1);
            PhonologicalAwareness saved = phonologicalAwarenessRepository.save(p);

            Feedback f = new Feedback();
            f.setPhonologicalAwareness(saved);
            f.setImage("https://cdn-icons-png.flaticon.com/512/599/599618.png");
            f.setFeedback(phonologicalFeedbackText((int) row[0]));
            feedbackRepository.save(f);
        }
    }

    private String phonologicalFeedbackText(int id) {
        return switch (id) {
            case 1  -> " Este animal hace \"miau\" y le gusta tomar leche.";
            case 2  -> " Este animal mueve la cola y hace \"guau guau\".";
            case 3  -> " Vive en el agua y nada con aletas.";
            case 4  -> " Es el \"rey\" de la selva y tiene melena.";
            case 5  -> " Es una fruta verde o amarilla, jugosa y dulce.";
            case 6  -> " Es una fruta pequeña y redondita, puede ser morada o verde.";
            case 7  -> " La usas para tomar agua, jugo o leche.";
            case 8  -> " Ahí comes y pones los platos en la casa.";
            case 9  -> " La usas para saludar, aplaudir y agarrar cosas.";
            case 10 -> " Va por las vías y hace \"chu chu\".";
            default -> "";
        };
    }

    // ─── NIVEL 2: FLUENT READING ─────────────────────────────────────────────────

    private void seedFluentReading() {
        if (fluentReadingRepository.count() > 0) return;

        Level level2 = levelRepository.findById(2).orElseThrow();

        List<Object[]> data = List.of(
            new Object[]{11, "https://cdn-icons-png.flaticon.com/512/4195/4195557.png", "¿Qué animal tiene la melena más grande?", "El león es conocido por su melena imponente.", "León", "Oso", "León", "Tigre"},
            new Object[]{12, "https://cdn-icons-png.flaticon.com/512/3791/3791180.png", "¿Cuál es el animal que suele saltar más alto?", "El canguro es famoso por sus saltos poderosos.", "Canguro", "Gato", "Canguro", "Perro"},
            new Object[]{13, "https://cdn-icons-png.flaticon.com/512/3436/3436895.png", "¿Qué animal es el rey de la selva?", "El león es llamado el rey de la selva por su fuerza y majestuosidad.", "León", "León", "Elefante", "Tigre"},
            new Object[]{14, "https://cdn-icons-png.flaticon.com/512/13404/13404871.png", "¿Qué mamífero puede volar?", "El murciélago es el único mamífero que tiene la capacidad de volar.", "Murciélago", "Águila", "Murciélago", "Perro"},
            new Object[]{15, "https://cdn-icons-png.flaticon.com/512/427/427406.png", "¿Qué animal es conocido por su capacidad para imitar sonidos?", "El loro es famoso por imitar sonidos y palabras humanas.", "Loro", "Loro", "Gato", "Perro"},
            new Object[]{16, "https://cdn-icons-png.flaticon.com/512/2233/2233656.png", "¿Qué insecto produce miel?", "Las abejas son conocidas por producir miel.", "Abeja", "Abeja", "Mosca", "Mariposa"},
            new Object[]{17, "https://cdn-icons-png.flaticon.com/512/1998/1998597.png", "¿Qué animal es conocido por su velocidad en la carrera?", "El guepardo es el animal terrestre más rápido en carreras cortas.", "Guepardo", "León", "Guepardo", "Elefante"},
            new Object[]{18, "https://cdn-icons-png.flaticon.com/512/3196/3196017.png", "¿Qué animal tiene la lengua más larga en relación con su tamaño?", "El camaleón es conocido por su lengua extremadamente larga.", "Camaleón", "Serpiente", "Camaleón", "Perro"},
            new Object[]{19, "https://cdn-icons-png.flaticon.com/512/3068/3068030.png", "¿Qué mamífero vive más tiempo?", "La ballena de Groenlandia puede vivir más de 200 años.", "Ballena", "Ballena", "Tortuga", "Elefante"},
            new Object[]{20, "https://cdn-icons-png.flaticon.com/512/3751/3751415.png", "¿Qué animal puede cambiar de color para camuflarse?", "El pulpo tiene la habilidad de cambiar de color para camuflarse en su entorno.", "Pulpo", "Pulpo", "Cangrejo", "Medusa"}
        );

        for (Object[] row : data) {
            FluentReading fr = new FluentReading();
            fr.setId((int) row[0]);
            fr.setMainImage((String) row[1]);
            fr.setQuestion((String) row[2]);
            fr.setStatement((String) row[3]);
            fr.setCorrectAnswer((String) row[4]);
            fr.setAnswerOne((String) row[5]);
            fr.setAnswerTwo((String) row[6]);
            fr.setAnswerThree((String) row[7]);
            fr.setUserResponse("");
            fr.setCorrect(false);
            fr.setLevel(level2);
            FluentReading saved = fluentReadingRepository.save(fr);

            Feedback f = new Feedback();
            f.setFluentReading(saved);
            f.setImage("https://cdn-icons-png.flaticon.com/512/599/599618.png");
            f.setFeedback(fluentFeedbackText((int) row[0]));
            feedbackRepository.save(f);
        }
    }

    private String fluentFeedbackText(int id) {
        return switch (id) {
            case 11 -> " Ruge muy fuerte en la selva, el rey de la selva tiene una melena increíblemente grande.";
            case 12 -> " Este animal salta grandes distancias, es conocido por su habilidad para saltar altísimo.";
            case 13 -> " Este animal es conocido por ser el más feroz en la jungla, su rugido resuena por todo el lugar.";
            case 14 -> " Aunque hay aves que vuelan, este mamífero es el único que tiene alas y puede volar.";
            case 15 -> " Este animal es conocido por su habilidad para hablar, imita sonidos de su entorno.";
            case 16 -> " Este insecto se encarga de hacer la miel, un producto dulce que utilizamos para endulzar.";
            case 17 -> " Este animal es extremadamente rápido, lo encuentras corriendo por las llanuras.";
            case 18 -> " Este animal tiene una lengua extremadamente larga que utiliza para atrapar su comida.";
            case 19 -> " Este animal es muy longevo, se cree que vive mucho más que la mayoría de los mamíferos.";
            case 20 -> " Este animal cambia de color, usándolo como camuflaje en su entorno acuático.";
            default -> "";
        };
    }

    // ─── NIVEL 3: READING COMPREHENSION ─────────────────────────────────────────

    private void seedReadingComprehension() {
        if (readingComprehensionRepository.count() > 0) return;

        Level level3 = levelRepository.findById(3).orElseThrow();

        List<Object[]> data = List.of(
            new Object[]{21, "https://cdn-icons-png.flaticon.com/512/6855/6855202.png", "¿De qué color eran los ojos del gato?", "Un gato callejero, con ojos de esmeralda, encontró un hogar en el corazón de una niña solitaria.", "Esmeralda", "Marrones", "Grises", "Esmeralda"},
            new Object[]{22, "https://cdn-icons-png.flaticon.com/512/6683/6683923.png", "¿Qué le dio la niña al gato?", "La niña vio al gatito con hambre y le dio un plato para que pueda comer tranquilo.", "Comida", "Agua", "Comida", "Juguete"},
            new Object[]{23, "https://cdn-icons-png.flaticon.com/512/3277/3277257.png", "¿Qué sonido hizo el gato?", "Cuando la niña se acercó, el gato la miró y pidió ayuda con un sonido suave.", "Miau", "Guau", "Miau", "Muu"},
            new Object[]{24, "https://cdn-icons-png.flaticon.com/512/2975/2975966.png", "¿A dónde llevó la niña al gato?", "La niña decidió cuidarlo y lo llevó con ella para que esté seguro y calentito.", "A su casa", "Al parque", "A su casa", "A la escuela"},
            new Object[]{25, "https://cdn-icons-png.flaticon.com/512/11646/11646037.png", "¿Dónde durmió el gato?", "Esa noche, el gato se acurrucó en un lugar suave y descansó sin miedo.", "En la cama", "En la cama", "En el techo", "En el árbol"},
            new Object[]{26, "https://cdn-icons-png.flaticon.com/512/8013/8013714.png", "¿Cómo se sentía la niña al inicio?", "La niña se sentía sola y triste, pero el gato se quedó a su lado acompañándola.", "Triste", "Triste", "Enojada", "Feliz"},
            new Object[]{27, "https://cdn-icons-png.flaticon.com/512/6503/6503644.png", "¿A dónde fueron por la mañana?", "Por la mañana, la niña y el gato salieron juntos a caminar y mirar flores.", "Al jardín", "Al jardín", "Al mercado", "A la playa"},
            new Object[]{28, "https://cdn-icons-png.flaticon.com/512/2963/2963626.png", "¿Con qué jugó el gato?", "El gato se animó y jugó un rato con un objeto redondo que rodaba por el piso.", "Pelota", "Pelota", "Libro", "Plato"},
            new Object[]{29, "https://cdn-icons-png.flaticon.com/512/11176/11176969.png", "¿Qué hizo la niña antes de dormir?", "Antes de dormir, la niña le dio cariño al gato para que se sienta querido.", "Lo acarició", "Lo acarició", "Lo bañó", "Lo escondió"},
            new Object[]{30, "https://cdn-icons-png.flaticon.com/512/1424/1424112.png", "¿Qué encontró el gato?", "Con el paso de los días, el gato dejó de estar solo porque encontró un lugar donde lo cuidaban.", "Un hogar", "Un hogar", "Un coche", "Un sombrero"}
        );

        for (Object[] row : data) {
            ReadingComprehension rc = new ReadingComprehension();
            rc.setId((int) row[0]);
            rc.setMainImage((String) row[1]);
            rc.setQuestion((String) row[2]);
            rc.setStatement((String) row[3]);
            rc.setCorrectAnswer((String) row[4]);
            rc.setAnswerOne((String) row[5]);
            rc.setAnswerTwo((String) row[6]);
            rc.setAnswerThree((String) row[7]);
            rc.setUserResponse("");
            rc.setCorrect(false);
            rc.setLevel(level3);
            ReadingComprehension saved = readingComprehensionRepository.save(rc);

            Feedback f = new Feedback();
            f.setReadingComprehension(saved);
            f.setImage("https://cdn-icons-png.flaticon.com/512/599/599618.png");
            f.setFeedback(readingFeedbackText((int) row[0]));
            feedbackRepository.save(f);
        }
    }

    private String readingFeedbackText(int id) {
        return switch (id) {
            case 21 -> "Vuelve a leer. Dice \"ojos de esmeralda\".";
            case 22 -> "Piensa en qué le dio para comer (no era un juguete).";
            case 23 -> "Es el sonido que hace un gatito cuando pide algo.";
            case 24 -> "La niña lo llevó a un lugar seguro para cuidarlo.";
            case 25 -> "Durmió en un lugar suave dentro de la casa.";
            case 26 -> "Al inicio se sentía sola. ¿Qué emoción es esa?";
            case 27 -> "Salieron a caminar y ver flores por la mañana.";
            case 28 -> "Jugó con algo redondo que rueda por el piso.";
            case 29 -> "Antes de dormir le dio cariño con sus manos.";
            case 30 -> "Encontró un lugar donde lo cuidaban y ya no estaba solo.";
            default -> "";
        };
    }

    // ─── NIVEL 4: COMBINATION READING IMAGES ────────────────────────────────────

    private void seedCombinationReadingImages() {
        if (combinationReadingImagesRepository.count() > 0) return;

        Level level4 = levelRepository.findById(4).orElseThrow();

        List<Object[]> data = List.of(
            new Object[]{31, "https://cdn-icons-png.flaticon.com/512/6683/6683923.png", "https://cdn-icons-png.flaticon.com/512/763/763773.png", "https://cdn-icons-png.flaticon.com/512/5654/5654367.png", "¿Cuál es la oración correcta para estas imágenes?", "El gato está comiendo", "El gato está comiendo", "El gato está llorando", "El gato está corriendo"},
            new Object[]{32, "https://cdn-icons-png.flaticon.com/512/3002/3002675.png", "https://cdn-icons-png.flaticon.com/512/10292/10292297.png", "https://cdn-icons-png.flaticon.com/512/3819/3819565.png", "¿Cuál es la oración correcta para estas imágenes?", "La niña está leyendo", "La niña está leyendo", "La niña está saltando", "La niña está durmiendo"},
            new Object[]{33, "https://cdn-icons-png.flaticon.com/512/12926/12926208.png", "https://cdn-icons-png.flaticon.com/512/18282/18282346.png", "https://cdn-icons-png.flaticon.com/512/5783/5783359.png", "¿Cuál es la oración correcta para estas imágenes?", "El perro está corriendo", "El perro está corriendo", "El perro está comiendo", "El perro está nadando"},
            new Object[]{34, "https://cdn-icons-png.flaticon.com/512/2853/2853700.png", "https://cdn-icons-png.flaticon.com/512/4416/4416355.png", "https://cdn-icons-png.flaticon.com/512/2853/2853704.png", "¿Cuál es la oración correcta para estas imágenes?", "El niño está lavandose las manos", "El niño está lavandose las manos", "El niño está comiendo", "El niño está manejando"},
            new Object[]{35, "https://cdn-icons-png.flaticon.com/512/4035/4035183.png", "https://cdn-icons-png.flaticon.com/512/12693/12693539.png", "https://cdn-icons-png.flaticon.com/512/1027/1027128.png", "¿Cuál es la oración correcta para estas imágenes?", "La mamá está cocinando", "La mamá está cocinando", "La mamá está durmiendo", "La mamá está pintando"},
            new Object[]{36, "https://cdn-icons-png.flaticon.com/512/1973/1973984.png", "https://cdn-icons-png.flaticon.com/512/4284/4284934.png", "https://cdn-icons-png.flaticon.com/512/1610/1610501.png", "¿Cuál es la oración correcta para estas imágenes?", "El tren está avanzando", "El tren está avanzando", "El tren está en la estación", "El tren está quieto"},
            new Object[]{37, "https://cdn-icons-png.flaticon.com/512/874/874960.png", "https://cdn-icons-png.flaticon.com/512/2977/2977361.png", "https://cdn-icons-png.flaticon.com/512/2739/2739409.png", "¿Cuál es la oración correcta para estas imágenes?", "El pez payaso está nadando", "El pez payaso está nadando", "El pez espada está nadando", "El pez globo está nadando"},
            new Object[]{38, "https://cdn-icons-png.flaticon.com/512/1071/1071132.png", "https://cdn-icons-png.flaticon.com/512/919/919471.png", "https://cdn-icons-png.flaticon.com/512/5284/5284182.png", "¿Cuál es la oración correcta para estas imágenes?", "La pelota está rodando", "La pelota está rodando", "La pelota está botando", "La pelota está siendo pateada"},
            new Object[]{39, "https://cdn-icons-png.flaticon.com/512/8208/8208756.png", "https://cdn-icons-png.flaticon.com/512/9927/9927186.png", "https://cdn-icons-png.flaticon.com/512/2077/2077988.png", "¿Cuál es la oración correcta para estas imágenes?", "El niño está aplaudiendo", "El niño está aplaudiendo", "El niño está corriendo", "El niño está llorando"},
            new Object[]{40, "https://cdn-icons-png.flaticon.com/512/5295/5295319.png", "https://cdn-icons-png.flaticon.com/512/2436/2436893.png", "https://cdn-icons-png.flaticon.com/512/3380/3380697.png", "¿Cuál es la oración correcta para estas imágenes?", "La niña está escribiendo", "La niña está escribiendo", "La niña está nadando", "La niña está leyendo"}
        );

        for (Object[] row : data) {
            CombinationReadingImages c = new CombinationReadingImages();
            c.setId((int) row[0]);
            c.setMainImage((String) row[1]);
            c.setSecondImage((String) row[2]);
            c.setThirdImage((String) row[3]);
            c.setQuestion((String) row[4]);
            c.setCorrectAnswer((String) row[5]);
            c.setAnswerOne((String) row[6]);
            c.setAnswerTwo((String) row[7]);
            c.setAnswerThree((String) row[8]);
            c.setStatement("");
            c.setUserResponse("");
            c.setCorrect(false);
            c.setLevel(level4);
            CombinationReadingImages saved = combinationReadingImagesRepository.save(c);

            Feedback f = new Feedback();
            f.setCombinationReadingImages(saved);
            f.setImage("https://cdn-icons-png.flaticon.com/512/599/599618.png");
            f.setFeedback(combinationFeedbackText((int) row[0]));
            feedbackRepository.save(f);
        }
    }

    private String combinationFeedbackText(int id) {
        return switch (id) {
            case 31 -> "Mira la imagen otra vez. ¿Qué está haciendo el gato?";
            case 32 -> "Fíjate en la acción. ¿Está leyendo, saltando o durmiendo?";
            case 33 -> "Observa al perro. Elige la oración que diga lo que hace.";
            case 34 -> "Mira las manos del niño. ¿Qué acción está haciendo?";
            case 35 -> "Observa a la mamá. Elige la oración que diga su acción.";
            case 36 -> "Mira el tren. Elige la oración que tenga sentido para esa imagen.";
            case 37 -> "Observa al pez. ¿Qué acción puede hacer en el agua?";
            case 38 -> "Mira la pelota. ¿Qué hace una pelota cuando se mueve?";
            case 39 -> "Mira las manos del niño. ¿Qué acción está haciendo con ellas?";
            case 40 -> "Observa a la niña. Elige la oración que describa lo que hace.";
            default -> "";
        };
    }

    // ─── NIVEL 5: VOCABULARY VERB ─────────────────────────────────────────────────

    private void seedVocabularyVerb() {
        if (vocabularyVerbRepository.count() > 0) return;

        Level level5 = levelRepository.findById(5).orElseThrow();

        List<Object[]> data = List.of(
            new Object[]{41, "https://cdn-icons-png.flaticon.com/512/4721/4721069.png", "¿Qué está haciendo el niño en la piscina?",
                "El niño está en la piscina junto a sus amigos. Mueve los brazos y las piernas dentro del agua para avanzar. Identifica el verbo.",
                "Nadando", "Nadando", "Leyendo", "Jugando", "Nadar", "Bañarse", "Flotar", "Sumergirse", "Chapotear"},
            new Object[]{42, "https://cdn-icons-png.flaticon.com/512/4509/4509721.png", "¿Qué está haciendo la niña en la mesa?",
                "La niña está sentada en la mesa. Tiene un plato y usa una cuchara para llevar la comida a su boca. Identifica el verbo.",
                "Comiendo", "Comiendo", "Durmiendo", "Saltando", "Comer", "Masticar", "Degustar", "Alimentarse", "Probar"},
            new Object[]{43, "https://cdn-icons-png.flaticon.com/512/9012/9012060.png", "¿Qué está haciendo el niño en el parque?",
                "El niño se mueve rápido con sus piernas por el parque. Va de un lugar a otro sin detenerse. Identifica el verbo.",
                "Corriendo", "Corriendo", "Pintando", "Cantando", "Correr", "Trotar", "Apurarse", "Acelerar", "Huir"},
            new Object[]{44, "https://cdn-icons-png.flaticon.com/512/2436/2436893.png", "¿Qué está haciendo la niña en su cuaderno?",
                "La niña sostiene un lápiz y hace letras en su cuaderno. Está formando palabras poco a poco. Identifica el verbo.",
                "Escribiendo", "Escribiendo", "Bailando", "Llorando", "Escribir", "Anotar", "Copiar", "Redactar", "Apuntar"},
            new Object[]{45, "https://cdn-icons-png.flaticon.com/512/2870/2870759.png", "¿Qué está haciendo el niño con las manos?",
                "El niño abre el caño, usa jabón y frota sus manos para dejarlas limpias. Identifica el verbo.",
                "Lavando", "Lavando", "Rompiendo", "Volando", "Lavar", "Enjuagar", "Frotar", "Limpiar", "Asear"},
            new Object[]{46, "https://cdn-icons-png.flaticon.com/512/14777/14777630.png", "¿Qué está haciendo la niña con la cuerda?",
                "La niña sostiene una cuerda y pasa por encima una y otra vez. Sus pies se levantan del suelo. Identifica el verbo.",
                "Saltando", "Saltando", "Durmiendo", "Caminando", "Saltar", "Brincar", "Rebotar", "Elevarse", "Saltarín"},
            new Object[]{47, "https://cdn-icons-png.flaticon.com/512/2593/2593750.png", "¿Qué está haciendo el niño con el vaso?",
                "El niño sostiene un vaso y lleva el líquido a su boca. Toma pequeños sorbos. Identifica el verbo.",
                "Bebiendo", "Bebiendo", "Leyendo", "Corriendo", "Beber", "Tomar", "Sorber", "Tragar", "Deglutir"},
            new Object[]{48, "https://cdn-icons-png.flaticon.com/512/3002/3002727.png", "¿Qué está haciendo la niña con la puerta?",
                "La niña empuja la puerta para que se mueva y deje pasar a las personas. Identifica el verbo.",
                "Abriendo", "Abriendo", "Cerrando", "Durmiendo", "Abrir", "Destapar", "Desbloquear", "Entornar", "Acceder"},
            new Object[]{49, "https://cdn-icons-png.flaticon.com/512/9543/9543718.png", "¿Qué está haciendo el niño con la música?",
                "El niño mueve su boca y hace sonidos con su voz siguiendo una canción. Identifica el verbo.",
                "Cantando", "Cantando", "Nadando", "Escribiendo", "Cantar", "Entonar", "Tararear", "Vocalizar", "Interpretar"},
            new Object[]{50, "https://cdn-icons-png.flaticon.com/512/7409/7409727.png", "¿Qué está haciendo la niña con sus juguetes?",
                "La niña usa sus juguetes para divertirse. Mueve las piezas y se entretiene con una actividad. Identifica el verbo.",
                "Jugando", "Jugando", "Llorando", "Cocinando", "Jugar", "Divertirse", "Entretenerse", "Participar", "Practicar"}
        );

        for (Object[] row : data) {
            VocabularyVerb vv = new VocabularyVerb();
            vv.setId((int) row[0]);
            vv.setMainImage((String) row[1]);
            vv.setQuestion((String) row[2]);
            vv.setStatement((String) row[3]);
            vv.setCorrectAnswer((String) row[4]);
            vv.setAnswerOne((String) row[5]);
            vv.setAnswerTwo((String) row[6]);
            vv.setAnswerThree((String) row[7]);
            vv.setWordSelectVerb((String) row[8]);
            vv.setVerbSynonymOne((String) row[9]);
            vv.setVerbSynonymTwo((String) row[10]);
            vv.setVerbSynonymThree((String) row[11]);
            vv.setVerbSynonymFour((String) row[12]);
            vv.setUserResponse("");
            vv.setCorrect(false);
            vv.setLevel(level5);
            VocabularyVerb saved = vocabularyVerbRepository.save(vv);

            Feedback f = new Feedback();
            f.setVocabularyVerb(saved);
            f.setImage("https://cdn-icons-png.flaticon.com/512/599/599618.png");
            f.setFeedback(vocabularyFeedbackText((int) row[0]));
            feedbackRepository.save(f);
        }
    }

    private String vocabularyFeedbackText(int id) {
        return switch (id) {
            case 41 -> "Piensa: ¿qué hace el niño dentro del agua para moverse?";
            case 42 -> "Mira la escena: ¿qué hace la persona cuando lleva comida a la boca?";
            case 43 -> "Observa: se mueve rápido con las piernas. ¿Qué acción es?";
            case 44 -> "Fíjate: usa lápiz y hace letras en el cuaderno. ¿Qué acción es?";
            case 45 -> "Mira: usa agua y jabón para dejar limpio. ¿Qué acción es?";
            case 46 -> "Observa: se levanta del suelo pasando la cuerda. ¿Qué acción es?";
            case 47 -> "Piensa: usa un vaso y toma líquido con la boca. ¿Qué acción es?";
            case 48 -> "Mira: mueve la puerta para dejar pasar. ¿Qué acción es?";
            case 49 -> "Escucha la idea: usa su voz con una canción. ¿Qué acción es?";
            case 50 -> "Observa: se divierte usando juguetes. ¿Qué acción es?";
            default -> "";
        };
    }
}
