module pokemon.ejemplo.crudexamen {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.persistence;
    requires org.hibernate.orm.core;
    requires com.sun.istack.runtime;

    opens pokemon.ejemplo.crudexamen to javafx.fxml, org.hibernate.orm.core;
    exports pokemon.ejemplo.crudexamen;

    opens pokemon.ejemplo.crudexamen.Controllers to javafx.fxml, org.hibernate.orm.core;
    exports pokemon.ejemplo.crudexamen.Controllers;

    opens pokemon.ejemplo.crudexamen.Models to javafx.fxml, org.hibernate.orm.core;
    exports pokemon.ejemplo.crudexamen.Models;

    opens pokemon.ejemplo.crudexamen.Objects to javafx.fxml, org.hibernate.orm.core;
    exports pokemon.ejemplo.crudexamen.Objects;
}