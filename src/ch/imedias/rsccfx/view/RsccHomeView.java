package ch.imedias.rsccfx.view;

import ch.imedias.rsccfx.model.Rscc;
import de.codecentric.centerdevice.javafxsvg.SvgImageLoaderFactory;
import java.io.InputStream;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 * Defines all elements shown on the start page.
 */
public class RsccHomeView extends BorderPane {
  private final Rscc model;

  HeaderView headerView;

  Button requestViewBtn = new Button();
  Button supportViewBtn = new Button();

  VBox mainView = new VBox();

  Image requestImg;
  Image supportImg;

  ImageView requestImgView;
  ImageView supportImgView;

  /**
   * Initializes all the GUI components needed on the start page.
   */
  public RsccHomeView(Rscc model) {
    this.model = model;
    SvgImageLoaderFactory.install();
    initFieldData();
    layoutForm();
    bindFieldsToModel();
  }

  private void initFieldData() {
    // populate fields which require initial data
    headerView = new HeaderView(model);

    //TODO: replace Text, multilangual
    //TODO: Different textsizes:
    //TODO: see here: http://stackoverflow.com/questions/12193785/different-textsizes-in-a-button
    requestViewBtn.textProperty().setValue("I need help\nGet somebody to help you remotely");
    supportViewBtn.textProperty().setValue("I want to help someone\nSomebody needs my help");
  }

  private void layoutForm() {
    InputStream requestHelpImagePath = getClass().getClassLoader()
        .getResourceAsStream("images/IneedHelp.svg");
    requestImg = new Image(requestHelpImagePath);
    requestImgView = new ImageView(requestImg);
    requestImgView.setPreserveRatio(true);
    requestViewBtn.setGraphic(requestImgView);
    requestViewBtn.getStyleClass().add("HomeNavigationBtn");

    InputStream offerSupportImagePath = getClass().getClassLoader()
        .getResourceAsStream("images/INeedSupport.svg");
    supportImg = new Image(offerSupportImagePath);
    supportImgView = new ImageView(supportImg);
    supportImgView.setPreserveRatio(true);
    supportViewBtn.setGraphic(supportImgView);
    supportViewBtn.getStyleClass().add("HomeNavigationBtn");

    mainView.getChildren().addAll(requestViewBtn, supportViewBtn);

    this.setTop(headerView);
    this.setCenter(mainView);
  }

  private void bindFieldsToModel() {
    // make bindings to the model
  }
}
