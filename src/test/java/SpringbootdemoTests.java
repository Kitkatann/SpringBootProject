
import com.software.institute.kathb.springbootdemo.actor.Actor;
import com.software.institute.kathb.springbootdemo.actor.ActorDTO;
import com.software.institute.kathb.springbootdemo.category.Category;
import com.software.institute.kathb.springbootdemo.film.Film;
import com.software.institute.kathb.springbootdemo.film.FilmDTO;
import com.software.institute.kathb.springbootdemo.filmactor.FilmActor;
import com.software.institute.kathb.springbootdemo.filmactor.FilmActorKey;
import com.software.institute.kathb.springbootdemo.filmcategory.FilmCategory;
import com.software.institute.kathb.springbootdemo.filmcategory.FilmCategoryKey;
import com.software.institute.kathb.springbootdemo.language.Language;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpringbootdemoTests {

    //--------------------- Actor entity tests----------------------------------------------------------------------
    @Test
    void test_getActorId() throws NoSuchFieldException, IllegalAccessException
    {
        Actor actor = new Actor();
        final Field field = actor.getClass().getDeclaredField("actorId");
        field.setAccessible(true);
        field.set(actor, 1);
        assertEquals(1, actor.getActorId(), "Cannot get actor id");
    }

    @Test
    void test_setActorId() throws NoSuchFieldException, IllegalAccessException
    {
        Actor actor = new Actor();
        actor.setActorId(1);
        final Field field = actor.getClass().getDeclaredField("actorId");
        field.setAccessible(true);
        assertEquals(1, field.get(actor), "Set actor id didn't work as expected");
    }

    @Test
    void test_getActorFirstName() throws NoSuchFieldException, IllegalAccessException
    {
        Actor actor = new Actor();
        final Field field = actor.getClass().getDeclaredField("firstName");
        field.setAccessible(true);
        field.set(actor, "John");
        assertEquals("John", actor.getFirstName(), "Cannot get actor first name");
    }

    @Test
    void test_setActorFirstName() throws NoSuchFieldException, IllegalAccessException
    {
        Actor actor = new Actor();
        actor.setFirstName("John");
        final Field field = actor.getClass().getDeclaredField("firstName");
        field.setAccessible(true);
        assertEquals("John", field.get(actor), "Set actor first name didn't work as expected");
    }

    @Test
    void test_getActorLastName() throws NoSuchFieldException, IllegalAccessException
    {
        Actor actor = new Actor();
        final Field field = actor.getClass().getDeclaredField("lastName");
        field.setAccessible(true);
        field.set(actor, "Smith");
        assertEquals("Smith", actor.getLastName(), "Cannot get actor last name");
    }

    @Test
    void test_setActorLastName() throws NoSuchFieldException, IllegalAccessException
    {
        Actor actor = new Actor();
        actor.setLastName("Smith");
        final Field field = actor.getClass().getDeclaredField("lastName");
        field.setAccessible(true);
        assertEquals("Smith", field.get(actor), "Set actor last name didn't work as expected");
    }

    @Test
    void test_getActorLastUpdate() throws NoSuchFieldException, IllegalAccessException
    {
        Actor actor = new Actor();
        final Field field = actor.getClass().getDeclaredField("lastUpdate");
        field.setAccessible(true);
        field.set(actor, "220-08-21 05:03:42");
        assertEquals("220-08-21 05:03:42", actor.getLastUpdate(), "Cannot get actor last update");
    }

    @Test
    void test_setActorLastUpdate() throws NoSuchFieldException, IllegalAccessException
    {
        Actor actor = new Actor();
        actor.setLastUpdate("220-08-21 05:03:42");
        final Field field = actor.getClass().getDeclaredField("lastUpdate");
        field.setAccessible(true);
        assertEquals("220-08-21 05:03:42", field.get(actor), "Set actor last update didn't work as expected");
    }

    //--------------------- Actor DTO tests----------------------------------------------------------------------

    @Test
    void test_getActorDTOId() throws NoSuchFieldException, IllegalAccessException
    {
        ActorDTO actorDTO = new ActorDTO();
        final Field field = actorDTO.getClass().getDeclaredField("actorId");
        field.setAccessible(true);
        field.set(actorDTO, 1);
        Optional<Integer> optional = Optional.of(1);
        assertEquals(optional, actorDTO.getActorId(), "Cannot get actor DTO id");
    }

    @Test
    void test_setActorDTOId() throws NoSuchFieldException, IllegalAccessException
    {
        ActorDTO actorDTO = new ActorDTO();
        actorDTO.setActorId(1);
        final Field field = actorDTO.getClass().getDeclaredField("actorId");
        field.setAccessible(true);
        assertEquals(1, field.get(actorDTO), "Set actor DTO id didn't work as expected");
    }

    @Test
    void test_getActorDTOFirstName() throws NoSuchFieldException, IllegalAccessException
    {
        ActorDTO actorDTO = new ActorDTO();
        final Field field = actorDTO.getClass().getDeclaredField("firstName");
        field.setAccessible(true);
        field.set(actorDTO, "John");
        Optional<String> optional = Optional.of("John");
        assertEquals(optional, actorDTO.getFirstName(), "Cannot get actor DTO first name");
    }

    @Test
    void test_setActorDTOFirstName() throws NoSuchFieldException, IllegalAccessException
    {
        ActorDTO actorDTO = new ActorDTO();
        actorDTO.setFirstName("John");
        final Field field = actorDTO.getClass().getDeclaredField("firstName");
        field.setAccessible(true);
        assertEquals("John", field.get(actorDTO), "Set actor DTO first name didn't work as expected");
    }

    @Test
    void test_getActorDTOLastName() throws NoSuchFieldException, IllegalAccessException
    {
        ActorDTO actorDTO = new ActorDTO();
        final Field field = actorDTO.getClass().getDeclaredField("lastName");
        field.setAccessible(true);
        field.set(actorDTO, "Smith");
        Optional<String> optional = Optional.of("Smith");
        assertEquals(optional, actorDTO.getLastName(), "Cannot get actor DTO last name");
    }

    @Test
    void test_setActorDTOLastName() throws NoSuchFieldException, IllegalAccessException
    {
        ActorDTO actorDTO = new ActorDTO();
        actorDTO.setLastName("Smith");
        final Field field = actorDTO.getClass().getDeclaredField("lastName");
        field.setAccessible(true);
        assertEquals("Smith", field.get(actorDTO), "Set actor DTO last name didn't work as expected");
    }

    @Test
    void test_getActorDTOLastUpdate() throws NoSuchFieldException, IllegalAccessException
    {
        ActorDTO actorDTO = new ActorDTO();
        final Field field = actorDTO.getClass().getDeclaredField("lastUpdate");
        field.setAccessible(true);
        field.set(actorDTO, "220-08-21 05:03:42");
        Optional<String> optional = Optional.of("220-08-21 05:03:42");
        assertEquals(optional, actorDTO.getLastUpdate(), "Cannot get actor DTO last update");
    }

    @Test
    void test_setActorDTOLastUpdate() throws NoSuchFieldException, IllegalAccessException
    {
        ActorDTO actorDTO = new ActorDTO();
        actorDTO.setLastUpdate("220-08-21 05:03:42");
        final Field field = actorDTO.getClass().getDeclaredField("lastUpdate");
        field.setAccessible(true);
        assertEquals("220-08-21 05:03:42", field.get(actorDTO), "Set actor DTO last update didn't work as expected");
    }

    //--------------------- Film tests----------------------------------------------------------------------

    @Test
    void test_getFilmId() throws NoSuchFieldException, IllegalAccessException
    {
        Film film = new Film();
        final Field field = film.getClass().getDeclaredField("filmId");
        field.setAccessible(true);
        field.set(film, 1);
        assertEquals(1, film.getFilmId(), "Cannot get film id");
    }

    @Test
    void test_setFilmId() throws NoSuchFieldException, IllegalAccessException
    {
        Film film = new Film();
        film.setFilmId(1);
        final Field field = film.getClass().getDeclaredField("filmId");
        field.setAccessible(true);
        assertEquals(1, field.get(film), "Set film id didn't work as expected");
    }

    @Test
    void test_getFilmTitle() throws NoSuchFieldException, IllegalAccessException
    {
        Film film = new Film();
        final Field field = film.getClass().getDeclaredField("title");
        field.setAccessible(true);
        field.set(film, "test title");
        assertEquals("test title", film.getTitle(), "Cannot get film title");
    }

    @Test
    void test_setFilmTitle() throws NoSuchFieldException, IllegalAccessException
    {
        Film film = new Film();
        film.setTitle("test title");
        final Field field = film.getClass().getDeclaredField("title");
        field.setAccessible(true);
        assertEquals("test title", field.get(film), "Set film title didn't work as expected");
    }

    @Test
    void test_getFilmDescription() throws NoSuchFieldException, IllegalAccessException
    {
        Film film = new Film();
        final Field field = film.getClass().getDeclaredField("description");
        field.setAccessible(true);
        field.set(film, "test description");
        assertEquals("test description", film.getDescription(), "Cannot get film description");
    }

    @Test
    void test_setFilmDescription() throws NoSuchFieldException, IllegalAccessException
    {
        Film film = new Film();
        film.setDescription("test description");
        final Field field = film.getClass().getDeclaredField("description");
        field.setAccessible(true);
        assertEquals("test description", field.get(film), "Set film description didn't work as expected");
    }

    @Test
    void test_getFilmReleaseYear() throws NoSuchFieldException, IllegalAccessException
    {
        Film film = new Film();
        final Field field = film.getClass().getDeclaredField("releaseYear");
        field.setAccessible(true);
        field.set(film, "2020");
        assertEquals("2020", film.getReleaseYear(), "Cannot get film release year");
    }

    @Test
    void test_setFilmReleaseYear() throws NoSuchFieldException, IllegalAccessException
    {
        Film film = new Film();
        film.setReleaseYear("2020");
        final Field field = film.getClass().getDeclaredField("releaseYear");
        field.setAccessible(true);
        assertEquals("2020", field.get(film), "Set film release year didn't work as expected");
    }


    @Test
    void test_getFilmLanguage() throws NoSuchFieldException, IllegalAccessException
    {
        Film film = new Film();
        final Field field = film.getClass().getDeclaredField("filmLanguage");
        field.setAccessible(true);
        Language language = new Language();
        language.setLanguageId(1);
        field.set(film, language);
        assertEquals(language, film.getFilmLanguage(), "Cannot get film language");
    }

    @Test
    void test_setFilmLanguage() throws NoSuchFieldException, IllegalAccessException
    {
        Film film = new Film();
        Language language = new Language();
        film.setFilmLanguage(language);
        final Field field = film.getClass().getDeclaredField("filmLanguage");
        field.setAccessible(true);
        assertEquals(language, field.get(film), "Set film language didn't work as expected");
    }

    @Test
    void test_getFilmLanguageId() throws NoSuchFieldException, IllegalAccessException
    {
        Film film = new Film();
        final Field field = film.getClass().getDeclaredField("languageId");
        field.setAccessible(true);
        film.setLanguageId(1);
        field.set(film, 1);
        assertEquals(1, film.getLanguageId(), "Cannot get film language id");
    }

    @Test
    void test_setFilmLanguageId() throws NoSuchFieldException, IllegalAccessException
    {
        Film film = new Film();
        film.setLanguageId(1);
        final Field field = film.getClass().getDeclaredField("languageId");
        field.setAccessible(true);
        assertEquals(1, field.get(film), "Set film language id didn't work as expected");
    }

    @Test
    void test_getFilmOriginalLanguage() throws NoSuchFieldException, IllegalAccessException
    {
        Film film = new Film();
        final Field field = film.getClass().getDeclaredField("originalFilmLanguage");
        field.setAccessible(true);
        Language language = new Language();
        language.setLanguageId(1);
        field.set(film, language);
        assertEquals(language, film.getOriginalFilmLanguage(), "Cannot get original film language");
    }

    @Test
    void test_setFilmOriginalLanguageId() throws NoSuchFieldException, IllegalAccessException
    {
        Film film = new Film();
        film.setOriginalLanguageId(1);
        final Field field = film.getClass().getDeclaredField("originalLanguageId");
        field.setAccessible(true);
        assertEquals(1, field.get(film), "Set original film language id didn't work as expected");
    }

    @Test
    void test_getFilmRentalDuration() throws NoSuchFieldException, IllegalAccessException
    {
        Film film = new Film();
        final Field field = film.getClass().getDeclaredField("rentalDuration");
        field.setAccessible(true);
        field.set(film, 23);
        assertEquals(23, film.getRentalDuration(), "Cannot get film rental duration");
    }

    @Test
    void test_setFilmRentalDuration() throws NoSuchFieldException, IllegalAccessException
    {
        Film film = new Film();
        film.setRentalDuration(23);
        final Field field = film.getClass().getDeclaredField("rentalDuration");
        field.setAccessible(true);
        assertEquals(23, field.get(film), "Set film rental duration didn't work as expected");
    }

    @Test
    void test_getFilmRentalRate() throws NoSuchFieldException, IllegalAccessException
    {
        Film film = new Film();
        final Field field = film.getClass().getDeclaredField("rentalRate");
        field.setAccessible(true);
        field.set(film, 4.99);
        assertEquals(4.99, film.getRentalRate(), "Cannot get film rental rate");
    }

    @Test
    void test_setFilmRentalRate() throws NoSuchFieldException, IllegalAccessException
    {
        Film film = new Film();
        film.setRentalRate(4.99);
        final Field field = film.getClass().getDeclaredField("rentalRate");
        field.setAccessible(true);
        assertEquals(4.99, field.get(film), "Set film rental rate didn't work as expected");
    }

    @Test
    void test_getFilmLength() throws NoSuchFieldException, IllegalAccessException
    {
        Film film = new Film();
        final Field field = film.getClass().getDeclaredField("length");
        field.setAccessible(true);
        field.set(film, 85);
        assertEquals(85, film.getLength(), "Cannot get film length");
    }

    @Test
    void test_setFilmLength() throws NoSuchFieldException, IllegalAccessException
    {
        Film film = new Film();
        film.setLength(85);
        final Field field = film.getClass().getDeclaredField("length");
        field.setAccessible(true);
        assertEquals(85, field.get(film), "Set film length didn't work as expected");
    }

    @Test
    void test_getFilmReplacementCost() throws NoSuchFieldException, IllegalAccessException
    {
        Film film = new Film();
        final Field field = film.getClass().getDeclaredField("replacementCost");
        field.setAccessible(true);
        field.set(film, 7.45);
        assertEquals(7.45, film.getReplacementCost(), "Cannot get film replacement cost");
    }

    @Test
    void test_setFilmReplacementCost() throws NoSuchFieldException, IllegalAccessException
    {
        Film film = new Film();
        film.setReplacementCost(7.45);
        final Field field = film.getClass().getDeclaredField("replacementCost");
        field.setAccessible(true);
        assertEquals(7.45, field.get(film), "Set film replacement cost didn't work as expected");
    }

    @Test
    void test_getFilmRating() throws NoSuchFieldException, IllegalAccessException
    {
        Film film = new Film();
        final Field field = film.getClass().getDeclaredField("rating");
        field.setAccessible(true);
        field.set(film, "PG");
        assertEquals("PG", film.getRating(), "Cannot get film rating");
    }

    @Test
    void test_setFilmRating() throws NoSuchFieldException, IllegalAccessException
    {
        Film film = new Film();
        film.setRating("PG");
        final Field field = film.getClass().getDeclaredField("rating");
        field.setAccessible(true);
        assertEquals("PG", field.get(film), "Set film rating didn't work as expected");
    }

    @Test
    void test_getFilmSpecialFeatures() throws NoSuchFieldException, IllegalAccessException
    {
        Film film = new Film();
        final Field field = film.getClass().getDeclaredField("specialFeatures");
        field.setAccessible(true);
        field.set(film, "Directors cut");
        assertEquals("Directors cut", film.getSpecialFeatures(), "Cannot get film special features");
    }

    @Test
    void test_setFilmSpecialFeatures() throws NoSuchFieldException, IllegalAccessException
    {
        Film film = new Film();
        film.setSpecialFeatures("Directors cut");
        final Field field = film.getClass().getDeclaredField("specialFeatures");
        field.setAccessible(true);
        assertEquals("Directors cut", field.get(film), "Set film special features didn't work as expected");
    }

    @Test
    void test_getFilmLastUpdate() throws NoSuchFieldException, IllegalAccessException
    {
        Film film = new Film();
        final Field field = film.getClass().getDeclaredField("lastUpdate");
        field.setAccessible(true);
        field.set(film, "220-08-21 05:03:42");
        assertEquals("220-08-21 05:03:42", film.getLastUpdate(), "Cannot get film last update");
    }

    @Test
    void test_setFilmLastUpdate() throws NoSuchFieldException, IllegalAccessException
    {
        Film film = new Film();
        film.setLastUpdate("220-08-21 05:03:42");
        final Field field = film.getClass().getDeclaredField("lastUpdate");
        field.setAccessible(true);
        assertEquals("220-08-21 05:03:42", field.get(film), "Set film last update didn't work as expected");
    }

    //--------------------- Film DTO tests----------------------------------------------------------------------

    @Test
    void test_getFilmDTOId() throws NoSuchFieldException, IllegalAccessException
    {
        FilmDTO filmDTO = new FilmDTO();
        final Field field = filmDTO.getClass().getDeclaredField("filmId");
        field.setAccessible(true);
        field.set(filmDTO, 1);
        Optional<Integer> optional = Optional.of(1);
        assertEquals(optional, filmDTO.getFilmId(), "Cannot get film DTO id");
    }

    @Test
    void test_setFilmDTOId() throws NoSuchFieldException, IllegalAccessException
    {
        FilmDTO filmDTO = new FilmDTO();
        filmDTO.setFilmId(1);
        final Field field = filmDTO.getClass().getDeclaredField("filmId");
        field.setAccessible(true);
        assertEquals(1, field.get(filmDTO), "Set film DTO id didn't work as expected");
    }

    @Test
    void test_getFilmDTOTitle() throws NoSuchFieldException, IllegalAccessException
    {
        FilmDTO filmDTO = new FilmDTO();
        final Field field = filmDTO.getClass().getDeclaredField("title");
        field.setAccessible(true);
        field.set(filmDTO, "test title");
        Optional<String> optional = Optional.of("test title");
        assertEquals(optional, filmDTO.getTitle(), "Cannot get film DTO title");
    }

    @Test
    void test_setFilmDTOTitle() throws NoSuchFieldException, IllegalAccessException
    {
        FilmDTO filmDTO = new FilmDTO();
        filmDTO.setTitle("test title");
        final Field field = filmDTO.getClass().getDeclaredField("title");
        field.setAccessible(true);
        assertEquals("test title", field.get(filmDTO), "Set film DTO title didn't work as expected");
    }

    @Test
    void test_getFilmDTODescription() throws NoSuchFieldException, IllegalAccessException
    {
        FilmDTO filmDTO = new FilmDTO();
        final Field field = filmDTO.getClass().getDeclaredField("description");
        field.setAccessible(true);
        field.set(filmDTO, "test description");
        Optional<String> optional = Optional.of("test description");
        assertEquals(optional, filmDTO.getDescription(), "Cannot get film DTO description");
    }

    @Test
    void test_setFilmDTODescription() throws NoSuchFieldException, IllegalAccessException
    {
        FilmDTO filmDTO = new FilmDTO();
        filmDTO.setDescription("test description");
        final Field field = filmDTO.getClass().getDeclaredField("description");
        field.setAccessible(true);
        assertEquals("test description", field.get(filmDTO), "Set film DTO description didn't work as expected");
    }

    @Test
    void test_getFilmDTOReleaseYear() throws NoSuchFieldException, IllegalAccessException
    {
        FilmDTO filmDTO = new FilmDTO();
        final Field field = filmDTO.getClass().getDeclaredField("releaseYear");
        field.setAccessible(true);
        field.set(filmDTO, "2020");
        Optional<String> optional = Optional.of("2020");
        assertEquals(optional, filmDTO.getReleaseYear(), "Cannot get film DTO release year");
    }

    @Test
    void test_setFilmDTOReleaseYear() throws NoSuchFieldException, IllegalAccessException
    {
        FilmDTO filmDTO = new FilmDTO();
        filmDTO.setReleaseYear("2020");
        final Field field = filmDTO.getClass().getDeclaredField("releaseYear");
        field.setAccessible(true);
        assertEquals("2020", field.get(filmDTO), "Set film DTO release year didn't work as expected");
    }

    @Test
    void test_getFilmDTOLanguageId() throws NoSuchFieldException, IllegalAccessException
    {
        FilmDTO filmDTO = new FilmDTO();
        final Field field = filmDTO.getClass().getDeclaredField("languageId");
        field.setAccessible(true);
        field.set(filmDTO, 1);
        Optional<Integer> optional = Optional.of(1);
        assertEquals(optional, filmDTO.getLanguageId(), "Cannot get film DTO language id");
    }

    @Test
    void test_setFilmDTOLanguageId() throws NoSuchFieldException, IllegalAccessException
    {
        FilmDTO filmDTO = new FilmDTO();
        filmDTO.setLanguageId(1);
        final Field field = filmDTO.getClass().getDeclaredField("languageId");
        field.setAccessible(true);
        assertEquals(1, field.get(filmDTO), "Set film DTO language id didn't work as expected");
    }

    @Test
    void test_getFilmDTOOriginalLanguageId() throws NoSuchFieldException, IllegalAccessException
    {
        FilmDTO filmDTO = new FilmDTO();
        final Field field = filmDTO.getClass().getDeclaredField("originalLanguageId");
        field.setAccessible(true);
        field.set(filmDTO, 1);
        Optional<Integer> optional = Optional.of(1);
        assertEquals(optional, filmDTO.getOriginalLanguageId(), "Cannot get film DTO original language id");
    }

    @Test
    void test_setFilmDTOOriginalLanguageId() throws NoSuchFieldException, IllegalAccessException
    {
        FilmDTO filmDTO = new FilmDTO();
        filmDTO.setOriginalLanguageId(1);
        final Field field = filmDTO.getClass().getDeclaredField("originalLanguageId");
        field.setAccessible(true);
        assertEquals(1, field.get(filmDTO), "Set film DTO original language id didn't work as expected");
    }

    @Test
    void test_getFilmDTORentalDuration() throws NoSuchFieldException, IllegalAccessException
    {
        FilmDTO filmDTO = new FilmDTO();
        final Field field = filmDTO.getClass().getDeclaredField("rentalDuration");
        field.setAccessible(true);
        field.set(filmDTO, 23);
        Optional<Integer> optional = Optional.of(23);
        assertEquals(optional, filmDTO.getRentalDuration(), "Cannot get film DTO rental duration");
    }

    @Test
    void test_setFilmDTORentalDuration() throws NoSuchFieldException, IllegalAccessException
    {
        FilmDTO filmDTO = new FilmDTO();
        filmDTO.setRentalDuration(23);
        final Field field = filmDTO.getClass().getDeclaredField("rentalDuration");
        field.setAccessible(true);
        assertEquals(23, field.get(filmDTO), "Set film DTO rental duration didn't work as expected");
    }

    @Test
    void test_getFilmDTORentalRate() throws NoSuchFieldException, IllegalAccessException
    {
        FilmDTO filmDTO = new FilmDTO();
        final Field field = filmDTO.getClass().getDeclaredField("rentalRate");
        field.setAccessible(true);
        field.set(filmDTO, 4.99);
        Optional<Double> optional = Optional.of(4.99);
        assertEquals(optional, filmDTO.getRentalRate(), "Cannot get film DTO rental rate");
    }

    @Test
    void test_setFilmDTORentalRate() throws NoSuchFieldException, IllegalAccessException
    {
        FilmDTO filmDTO = new FilmDTO();
        filmDTO.setRentalRate(4.99);
        final Field field = filmDTO.getClass().getDeclaredField("rentalRate");
        field.setAccessible(true);
        assertEquals(4.99, field.get(filmDTO), "Set film DTO rental rate didn't work as expected");
    }

    @Test
    void test_getFilmDTOLength() throws NoSuchFieldException, IllegalAccessException
    {
        FilmDTO filmDTO = new FilmDTO();
        final Field field = filmDTO.getClass().getDeclaredField("length");
        field.setAccessible(true);
        field.set(filmDTO, 85);
        Optional<Integer> optional = Optional.of(85);
        assertEquals(optional, filmDTO.getLength(), "Cannot get film DTO length");
    }

    @Test
    void test_setFilmDTOLength() throws NoSuchFieldException, IllegalAccessException
    {
        FilmDTO filmDTO = new FilmDTO();
        filmDTO.setLength(85);
        final Field field = filmDTO.getClass().getDeclaredField("length");
        field.setAccessible(true);
        assertEquals(85, field.get(filmDTO), "Set film DTO length didn't work as expected");
    }

    @Test
    void test_getFilmDTOReplacementCost() throws NoSuchFieldException, IllegalAccessException
    {
        FilmDTO filmDTO = new FilmDTO();
        final Field field = filmDTO.getClass().getDeclaredField("replacementCost");
        field.setAccessible(true);
        field.set(filmDTO, 7.45);
        Optional<Double> optional = Optional.of(7.45);
        assertEquals(optional, filmDTO.getReplacementCost(), "Cannot get film DTO replacement cost");
    }

    @Test
    void test_setFilmDTOReplacementCost() throws NoSuchFieldException, IllegalAccessException
    {
        FilmDTO filmDTO = new FilmDTO();
        filmDTO.setReplacementCost(7.45);
        final Field field = filmDTO.getClass().getDeclaredField("replacementCost");
        field.setAccessible(true);
        assertEquals(7.45, field.get(filmDTO), "Set film DTO replacement cost didn't work as expected");
    }

    @Test
    void test_getFilmDTORating() throws NoSuchFieldException, IllegalAccessException
    {
        FilmDTO filmDTO = new FilmDTO();
        final Field field = filmDTO.getClass().getDeclaredField("rating");
        field.setAccessible(true);
        field.set(filmDTO, "PG");
        Optional<String> optional = Optional.of("PG");
        assertEquals(optional, filmDTO.getRating(), "Cannot get film DTO rating");
    }

    @Test
    void test_setFilmDTORating() throws NoSuchFieldException, IllegalAccessException
    {
        FilmDTO filmDTO = new FilmDTO();
        filmDTO.setRating("PG");
        final Field field = filmDTO.getClass().getDeclaredField("rating");
        field.setAccessible(true);
        assertEquals("PG", field.get(filmDTO), "Set film DTO rating didn't work as expected");
    }

    @Test
    void test_getFilmDTOSpecialFeatures() throws NoSuchFieldException, IllegalAccessException
    {
        FilmDTO filmDTO = new FilmDTO();
        final Field field = filmDTO.getClass().getDeclaredField("specialFeatures");
        field.setAccessible(true);
        field.set(filmDTO, "Directors cut");
        Optional<String> optional = Optional.of("Directors cut");
        assertEquals(optional, filmDTO.getSpecialFeatures(), "Cannot get film DTO special features");
    }

    @Test
    void test_setFilmDTOSpecialFeatures() throws NoSuchFieldException, IllegalAccessException
    {
        FilmDTO filmDTO = new FilmDTO();
        filmDTO.setSpecialFeatures("Directors cut");
        final Field field = filmDTO.getClass().getDeclaredField("specialFeatures");
        field.setAccessible(true);
        assertEquals("Directors cut", field.get(filmDTO), "Set film DTO special features didn't work as expected");
    }

    //--------------------- Category tests----------------------------------------------------------------------

    @Test
    void test_getCategoryId() throws NoSuchFieldException, IllegalAccessException
    {
        Category category = new Category();
        final Field field = category.getClass().getDeclaredField("categoryId");
        field.setAccessible(true);
        field.set(category, 1);
        assertEquals(1, category.getCategoryId(), "Cannot get category id");
    }

    @Test
    void test_setCategoryId() throws NoSuchFieldException, IllegalAccessException
    {
        Category category = new Category();
        category.setCategoryId(1);
        final Field field = category.getClass().getDeclaredField("categoryId");
        field.setAccessible(true);
        assertEquals(1, field.get(category), "Set category id didn't work as expected");
    }

    @Test
    void test_getCategoryName() throws NoSuchFieldException, IllegalAccessException
    {
        Category category = new Category();
        final Field field = category.getClass().getDeclaredField("name");
        field.setAccessible(true);
        field.set(category, "Horror");
        assertEquals("Horror", category.getName(), "Cannot get category name");
    }

    @Test
    void test_setCategoryName() throws NoSuchFieldException, IllegalAccessException
    {
        Category category = new Category();
        category.setName("Horror");
        final Field field = category.getClass().getDeclaredField("name");
        field.setAccessible(true);
        assertEquals("Horror", field.get(category), "Set category name didn't work as expected");
    }

    @Test
    void test_getCategoryLastUpdate() throws NoSuchFieldException, IllegalAccessException
    {
        Category category = new Category();
        final Field field = category.getClass().getDeclaredField("lastUpdate");
        field.setAccessible(true);
        field.set(category, "220-08-21 05:03:42");
        assertEquals("220-08-21 05:03:42", category.getLastUpdate(), "Cannot get category last update");
    }

    @Test
    void test_setCategoryLastUpdate() throws NoSuchFieldException, IllegalAccessException
    {
        Category category = new Category();
        category.setLastUpdate("220-08-21 05:03:42");
        final Field field = category.getClass().getDeclaredField("lastUpdate");
        field.setAccessible(true);
        assertEquals("220-08-21 05:03:42", field.get(category), "Set category last update didn't work as expected");
    }

    //--------------------- Language tests----------------------------------------------------------------------

    @Test
    void test_getLanguageId() throws NoSuchFieldException, IllegalAccessException
    {
        Language language = new Language();
        final Field field = language.getClass().getDeclaredField("languageId");
        field.setAccessible(true);
        field.set(language, 1);
        assertEquals(1, language.getLanguageId(), "Cannot get language id");
    }

    @Test
    void test_setLanguageId() throws NoSuchFieldException, IllegalAccessException
    {
        Language language = new Language();
        language.setLanguageId(1);
        final Field field = language.getClass().getDeclaredField("languageId");
        field.setAccessible(true);
        assertEquals(1, field.get(language), "Set language id didn't work as expected");
    }

    @Test
    void test_getLanguageName() throws NoSuchFieldException, IllegalAccessException
    {
        Language language = new Language();
        final Field field = language.getClass().getDeclaredField("name");
        field.setAccessible(true);
        field.set(language, "English");
        assertEquals("English", language.getName(), "Cannot get language name");
    }

    @Test
    void test_setLanguageName() throws NoSuchFieldException, IllegalAccessException
    {
        Language language = new Language();
        language.setName("English");
        final Field field = language.getClass().getDeclaredField("name");
        field.setAccessible(true);
        assertEquals("English", field.get(language), "Set language name didn't work as expected");
    }

    @Test
    void test_getLanguageLastUpdate() throws NoSuchFieldException, IllegalAccessException
    {
        Language language = new Language();
        final Field field = language.getClass().getDeclaredField("lastUpdate");
        field.setAccessible(true);
        field.set(language, "220-08-21 05:03:42");
        assertEquals("220-08-21 05:03:42", language.getLastUpdate(), "Cannot get language last update");
    }

    @Test
    void test_setLanguageLastUpdate() throws NoSuchFieldException, IllegalAccessException
    {
        Language language = new Language();
        language.setLastUpdate("220-08-21 05:03:42");
        final Field field = language.getClass().getDeclaredField("lastUpdate");
        field.setAccessible(true);
        assertEquals("220-08-21 05:03:42", field.get(language), "Set language last update didn't work as expected");
    }

    //--------------------- FilmActorKey tests----------------------------------------------------------------------

    @Test
    void test_getFilmActorKeyActorId() throws NoSuchFieldException, IllegalAccessException
    {
        FilmActorKey filmActorKey = new FilmActorKey();
        final Field field = filmActorKey.getClass().getDeclaredField("actorId");
        field.setAccessible(true);
        field.set(filmActorKey, 1);
        assertEquals(1, filmActorKey.getActorId(), "Cannot get film actor key actor id");
    }

    @Test
    void test_setFilmActorKeyActorId() throws NoSuchFieldException, IllegalAccessException
    {
        FilmActorKey filmActorKey = new FilmActorKey();
        filmActorKey.setActorId(1);
        final Field field = filmActorKey.getClass().getDeclaredField("actorId");
        field.setAccessible(true);
        assertEquals(1, field.get(filmActorKey), "Set film actor key actor id didn't work as expected");
    }

    @Test
    void test_getFilmActorKeyFilmId() throws NoSuchFieldException, IllegalAccessException
    {
        FilmActorKey filmActorKey = new FilmActorKey();
        final Field field = filmActorKey.getClass().getDeclaredField("filmId");
        field.setAccessible(true);
        field.set(filmActorKey, 1);
        assertEquals(1, filmActorKey.getFilmId(), "Cannot get film actor key film id");
    }

    @Test
    void test_setFilmActorKeyFilmId() throws NoSuchFieldException, IllegalAccessException
    {
        FilmActorKey filmActorKey = new FilmActorKey();
        filmActorKey.setFilmId(1);
        final Field field = filmActorKey.getClass().getDeclaredField("filmId");
        field.setAccessible(true);
        assertEquals(1, field.get(filmActorKey), "Set film actor key actor id didn't work as expected");
    }

    //--------------------- FilmActor tests----------------------------------------------------------------------

    @Test
    void test_getFilmActorId() throws NoSuchFieldException, IllegalAccessException
    {
        FilmActor filmActor = new FilmActor();
        final Field field = filmActor.getClass().getDeclaredField("id");
        field.setAccessible(true);
        FilmActorKey filmActorKey = new FilmActorKey();
        field.set(filmActor, filmActorKey);
        assertEquals(filmActorKey, filmActor.getId(), "Cannot get film actor id");
    }

    @Test
    void test_setFilmActorId() throws NoSuchFieldException, IllegalAccessException
    {
        FilmActor filmActor = new FilmActor();
        FilmActorKey filmActorKey = new FilmActorKey();
        filmActor.setId(filmActorKey);
        final Field field = filmActor.getClass().getDeclaredField("id");
        field.setAccessible(true);
        assertEquals(filmActorKey, field.get(filmActor), "Set film actor id didn't work as expected");
    }

    //--------------------- FilmCategoryKey tests----------------------------------------------------------------------

    @Test
    void test_getFilmCategoryKeyFilmId() throws NoSuchFieldException, IllegalAccessException
    {
        FilmCategoryKey filmCategoryKey = new FilmCategoryKey();
        final Field field = filmCategoryKey.getClass().getDeclaredField("filmId");
        field.setAccessible(true);
        field.set(filmCategoryKey, 1);
        assertEquals(1, filmCategoryKey.getFilmId(), "Cannot get film category key film id");
    }

    @Test
    void test_setFilmCategoryKeyFilmId() throws NoSuchFieldException, IllegalAccessException
    {
        FilmCategoryKey filmCategoryKey = new FilmCategoryKey();
        filmCategoryKey.setFilmId(1);
        final Field field = filmCategoryKey.getClass().getDeclaredField("filmId");
        field.setAccessible(true);
        assertEquals(1, field.get(filmCategoryKey), "Set film category key film id didn't work as expected");
    }

    @Test
    void test_getFilmCategoryKeyCategoryId() throws NoSuchFieldException, IllegalAccessException
    {
        FilmCategoryKey filmCategoryKey = new FilmCategoryKey();
        final Field field = filmCategoryKey.getClass().getDeclaredField("categoryId");
        field.setAccessible(true);
        field.set(filmCategoryKey, 1);
        assertEquals(1, filmCategoryKey.getCategoryId(), "Cannot get film category key category id");
    }

    @Test
    void test_setFilmCategoryKeyCategoryId() throws NoSuchFieldException, IllegalAccessException
    {
        FilmCategoryKey filmCategoryKey = new FilmCategoryKey();
        filmCategoryKey.setCategoryId(1);
        final Field field = filmCategoryKey.getClass().getDeclaredField("categoryId");
        field.setAccessible(true);
        assertEquals(1, field.get(filmCategoryKey), "Set film actor key actor id didn't work as expected");
    }

    //--------------------- FilmCategory tests----------------------------------------------------------------------

    @Test
    void test_getFilmCategoryId() throws NoSuchFieldException, IllegalAccessException
    {
        FilmCategory filmCategory = new FilmCategory();
        final Field field = filmCategory.getClass().getDeclaredField("id");
        field.setAccessible(true);
        FilmCategoryKey filmCategoryKey = new FilmCategoryKey();
        field.set(filmCategory, filmCategoryKey);
        assertEquals(filmCategoryKey, filmCategory.getId(), "Cannot get film category id");
    }

    @Test
    void test_setFilmCategoryId() throws NoSuchFieldException, IllegalAccessException
    {
        FilmCategory filmCategory = new FilmCategory();
        FilmCategoryKey filmCategoryKey = new FilmCategoryKey();
        filmCategory.setId(filmCategoryKey);
        final Field field = filmCategory.getClass().getDeclaredField("id");
        field.setAccessible(true);
        assertEquals(filmCategoryKey, field.get(filmCategory), "Set film category id didn't work as expected");
    }
}
