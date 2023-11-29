package de.winzermuseum.java.photoshop.gui;

import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Optional;
import java.util.ResourceBundle;
import javax.imageio.ImageIO;
import javax.swing.*;

import de.winzermuseum.java.photoshop.trans.*;
import de.winzermuseum.java.photoshop.trans.*;
import de.winzermuseum.java.photoshop.ImageEditor;


/**
 * Hauptfenster der GUI für die Bildbearbeitung
 */
public class ImageEditorGUI extends JFrame
{
  private static final int INITIAL_WIDTH = 1024;
  private static final int INITIAL_HEIGHT = 768;
  private static final String ICONS_DIR = "icons/";
  private final ResourceBundle resources;
  private final Collection<JComponent> imageTools = new LinkedList<>();
  final JToolBar toolBar;
  private final FileDialog fileDialog;
  private final FilterMatrixPanel filterMatrixPanel;
  private File imageFile = null;
  private final ImagePanel imagePanel = new ImagePanel();
  private TransformWorker worker = null;

  final boolean autoload = Boolean.parseBoolean(ImageEditor.inputargs[0]);


  /**
   * Erzeugt das Hauptfenster und zeigt dieses an.
   */
  public ImageEditorGUI(final ResourceBundle resources)
  {

    super(resources.getString("main.title"));

    this.resources = resources;

    toolBar = new JToolBar();

    toolBar.add(createTool(
        "action.file.open",
        "file-open.png",
        e -> loadImage(),
        null));
    toolBar.add(createTool(
        "action.file.reload",
        "file-reload.png",
        e -> readImage(),
        imageTools));
    toolBar.addSeparator();
    toolBar.add(createTool(
        "action.image.reflect.hor",
        "flip-horizontal.png",
        e -> transform(new ReflectionHorizontal()),
        imageTools));
    toolBar.add(createTool(
        "action.image.reflect.vert",
        "flip-vertical.png",
        e -> transform(new ReflectionVertical()),
        imageTools));
    toolBar.addSeparator();
    toolBar.add(createTool(
        "action.image.rotate.left",
        "rotate-left-90.png",
        e -> transform(new RotationLeft()),
        imageTools));
    toolBar.add(createTool(
        "action.image.rotate.right",
        "rotate-right-90.png",
        e -> transform(new RotationRight()),
        imageTools));
    toolBar.addSeparator();
    toolBar.add(createTool(
        "action.image.colour.red",
        "colour-red.png",
        e -> transform(new ExtractorRed()),
        imageTools));
    toolBar.add(createTool(
        "action.image.colour.green",
        "colour-green.png",
        e -> transform(new ExtractorGreen()),
        imageTools));
    toolBar.add(createTool(
        "action.image.colour.blue",
        "colour-blue.png",
        e -> transform(new ExtractorBlue()),
        imageTools));
    toolBar.addSeparator();
    toolBar.add(createTool(
        "action.image.colour.gray.avg",
        "colour-gray-avg.png",
        e -> transform(new GrayConverterAverage()),
        imageTools));
    toolBar.add(createTool(
        "action.image.colour.gray.lum",
        "colour-gray-lum.png",
        e -> transform(new GrayConverterLuminance()),
        imageTools));
    toolBar.addSeparator();
    toolBar.add(createTool(
        "action.image.filter.convolution",
        "filter-convolution.png",
        e -> filterImage(),
        imageTools));
    toolBar.addSeparator();
    toolBar.add(createTool(
        "action.image.filter.alphatrans",
        "filter-convolution.png",
        e -> transform(new TransformAlpha()),
        imageTools
    ));

    imageTools.forEach(button -> button.setEnabled(false));

    fileDialog = new FileDialog(this);
    fileDialog.setTitle(resources.getString("action.file.open"));
    fileDialog.setMode(FileDialog.LOAD);

    filterMatrixPanel = new FilterMatrixPanel(resources);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    add(toolBar, BorderLayout.NORTH);
    add(new JScrollPane(imagePanel), BorderLayout.CENTER);
    pack();
    setResizable(true);
    setSize(INITIAL_WIDTH, INITIAL_HEIGHT);
    setVisible(true);

    //Execute loadimage if a image is mentioned in cli args

    if( autoload == true){
      loadImage();
    }
  }


  /**
   * Zeigt modalen einen Dialog zum Öffnen der Datei an.
   * Lädt, falls möglich, das ausgewählte Bild und stellt diese dar.
   * Zeigt anderenfalls einen modalen Fehlerdialog an.
   */
  public void loadImage()
  {
    boolean filedialogvis = true;
    if(autoload == true){
      filedialogvis = false;
    }
    fileDialog.setVisible(filedialogvis);
    if (autoload == true) {
      final String directory = ImageEditor.inputargs[1];
      final String fileName = ImageEditor.inputargs[2];

      if (directory != null && fileName != null) {
        imageFile = new File(directory, fileName);
        readImage();
      }
    }
    else {
        final String directory2 = fileDialog.getDirectory();
        final String fileName2 = fileDialog.getFile();

        if (directory2 != null && fileName2 != null)
        {
         imageFile = new File(directory2, fileName2);
         readImage();
       }
     }

  }


  /**
   * Lädt, falls möglich, das ausgewählte Bild und stellt diese dar.
   * Zeigt anderenfalls einen modalen Fehlerdialog an.
   */
  public void readImage()
  {
    if (imageFile != null)
    {
      try
      {
        imagePanel.setImage(ImageIO.read(imageFile));
        imageTools.forEach(button -> button.setEnabled(true));
      }
      catch (final IOException e)
      {
        imageTools.forEach(button -> button.setEnabled(false));
        JOptionPane.showMessageDialog(null,
            resources.getString("error.file.load"),
            resources.getString("error.title"),
            JOptionPane.ERROR_MESSAGE);
        System.out.println("Hey");
      }
    }
  }


  /**
   * Transformiert ein Bild und aktualisiert die Anzeige.
   *
   * @param transformer Implementierung des Algorithmus
   */
  private void transform(final Transformer transformer)
  {
    if (worker != null)
    {
      worker.cancel(true);
    }

    worker = new TransformWorker(imagePanel, transformer, resources);
    worker.execute();
  }


  /**
   * Zeigt einen Dialog zur Eingabe der Filterkoeffizienten an.
   * Wendet den Filter an, falls der Dialog mit OK geschlossen wird.
   */
  private void filterImage()
  {
    final int result = JOptionPane.showConfirmDialog(
        this, filterMatrixPanel,
        resources.getString("convolution.title"),
        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

    if (result == JOptionPane.OK_OPTION)
    {
      transform(new Convolution(filterMatrixPanel.getFilterMatrix()));
    }
  }


  /**
   * Fügt der Werkzeugleiste ein Werkzeug hinzu.
   *
   * @param toolNameKey Schlüssel für die Bezeichnung des Werkzeugs
   * @param iconFileName Name der Icon-Datei
   * @param actionListener auszuführende Aktion
   * @param group Gruppe von Tools
   */
  private JComponent createTool(final String toolNameKey,
                                final String iconFileName,
                                final ActionListener actionListener,
                                final Collection<JComponent> group)
  {
    final String toolName = resources.getString(toolNameKey);

    final JButton button = new JButton();
    button.setToolTipText(toolName);
    button.addActionListener(actionListener);

    try
    {
      final ClassLoader classLoader = getClass().getClassLoader();
      final URL iconFileURL = classLoader.getResource(ICONS_DIR + iconFileName);
      assert iconFileURL != null;
      final File iconFile = new File(iconFileURL.toURI());
      button.setIcon(new ImageIcon(ImageIO.read(iconFile)));
    }
    catch (Exception ignored)
    {
      button.setText(toolName);
    }

    if (group != null)
    {
      group.add(button);
    }

    return button;
  }
}


