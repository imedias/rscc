package ch.imedias.rsccfx;

import ch.imedias.rsccfx.model.Rscc;
import ch.imedias.rsccfx.model.SystemCommander;
import ch.imedias.rsccfx.view.RsccEnterTokenPresenter;
import ch.imedias.rsccfx.view.RsccShowTokenPresenter;

import ch.imedias.rsccfx.view.RsccHomeView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RsccApp extends Application {
  public static final String APP_NAME = "Remote Support - Enter Token";
  Rscc model;

  public static void main(String[] args) {
    Application.launch(args);
  }


  @Override
  public void start(Stage stage) {
    model = new Rscc(new SystemCommander());
    // RsccShowTokenView showTokenView = new RsccShowTokenView(model);
    // RsccEnterTokenView enterTokenView = new RsccEnterTokenView(model);
    RsccHomeView view = new RsccHomeView(model);


    // the scene to listen for the focus change
    Scene scene = new Scene(view);
    String stSheet = getClass().getClassLoader().getResource("css/HomeStyle.css").toExternalForm();
    scene.getStylesheets().add(stSheet);
    ch.imedias.rsccfx.view.RsccViewPresenter presenter = new ch.imedias.rsccfx.view.RsccViewPresenter(model, view);
    //RsccShowTokenPresenter showTokenPresenter = new RsccShowTokenPresenter(model, showTokenView);
    //RsccEnterTokenPresenter enterTokenPresenter = new RsccEnterTokenPresenter(model, enterTokenView);

    stage.setWidth(1000);
    stage.setHeight(450);
    stage.setMinWidth(250);
    stage.setMinHeight(300);
    stage.setScene(scene);

    view.initBtnPanel(scene);

    stage.setTitle(APP_NAME);
    stage.setHeight(400);
    stage.setWidth(700);
    stage.show();

  }

  @Override
  public void stop() throws Exception {
    model.killConnection(model.getKey());
    super.stop();
  }
}
