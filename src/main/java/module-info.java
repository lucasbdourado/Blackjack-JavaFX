module br.com.lucasbdourado.baralho {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires net.synedra.validatorfx;
    requires com.almasb.fxgl.all;

    opens br.com.lucasbdourado.baralho to javafx.fxml;
    exports br.com.lucasbdourado.baralho;
    exports br.com.lucasbdourado.baralho.controller;
    opens br.com.lucasbdourado.baralho.controller to javafx.fxml;
}