import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

public class mainGUI {

    // here are the max variables for packages
    int maxHeight;
    int maxWidth;
    int maxLength;
    int maxWeight;

    // here are the max variables for letters
    int maxWeightLetters;

    //here are the variables datas
    double dataHeight;
    double dataWidth;
    double dataLength;
    double dataWeight;
    double dataQuantities;
    String dataDestination;
    double dataPrice;

    int maximumPackages;
    int maximumLetters;

    public mainGUI(int maxHeight, int maxWidth, int maxLength, int maxWeight, int maxWeightLetters, double dataHeight, double dataWidth, double dataLength, double dataWeight, double dataQuantities, String dataDestination, double dataPrice, int maximumPackages, int maximumLetters) {
        this.maxHeight = maxHeight;//cm
        this.maxWidth = maxWidth;//cm
        this.maxLength = maxLength;//cm1600
        this.maxWeight = maxWeight;//kg
        this.maxWeightLetters = maxWeightLetters;//g
        this.dataHeight = dataHeight;
        this.dataWidth = dataWidth;
        this.dataLength = dataLength;
        this.dataWeight = dataWeight;
        this.dataQuantities = dataQuantities;
        this.dataDestination = dataDestination;
        this.dataPrice = dataPrice;
        this.maximumPackages = maximumPackages;
        this.maximumLetters = maximumLetters;
    }

    private static List<PackageData> sentPackages = new ArrayList<>();
    static DefaultTableModel modelPackages = new DefaultTableModel();


    // Classe interne PackageData
    public static class PackageData {
        private double height;
        private double width;
        private double length;
        private double weight;
        private int quantity;
        private String destination;
        private double price;

        // Constructeur
        public PackageData(double height, double width, double length, double weight, int quantity, String destination, double price) {
            this.height = height;
            this.width = width;
            this.length = length;
            this.weight = weight;
            this.quantity = quantity;
            this.destination = destination;
            this.price = price;

        }
    }

    private static List<LettersData> sentLetters = new ArrayList<>();
    static DefaultTableModel modelLetters = new DefaultTableModel();


    // Classe interne LettersData
    public static class LettersData {
        private double weight;
        private int quantity;
        private String destination;
        private double price;;

        // Constructeur
        public LettersData(double weight, int quantity, String destination, double price) {
            this.weight = weight;
            this.quantity = quantity;
            this.destination = destination;
            this.price = price;
        }
    }

    public static void packagesToSend (int maxHeight, int maxWidth, int maxLength, int maxWeight, DefaultTableModel modelPackages, int maximumPackages) {
        // Creating the frame
        JFrame window = new JFrame("Packages page");
        window.setBounds(500,0,600,1000);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(null);
        window.setResizable(false);

        window.getContentPane().setBackground(Color.LIGHT_GRAY);

        // text for features to warn people
        JLabel cl = new JLabel("MAXIMUM DIMENSIONS OF PACKAGES : " );
        cl.setBounds(150, 40, 800, 50);
        window.add(cl);

        // text for features to warn people
        JLabel mHeight = new JLabel("Maximum height : " + maxHeight + " cm" );
        mHeight.setBounds(10, 80, 800, 50);
        window.add(mHeight);

        JLabel mWidth = new JLabel("Maximum width : " + maxWidth + " cm");
        mWidth.setBounds(10, 120, 800, 50);
        window.add(mWidth);

        JLabel mlength = new JLabel("Maximum length : " + maxLength + " cm");
        mlength.setBounds(10, 160, 800, 50);
        window.add(mlength);

        JLabel mWeight = new JLabel("Maximum weight : " + maxWeight + " kg");
        mWeight.setBounds(10, 200, 800, 50);
        window.add(mWeight);

        JLabel combien = new JLabel("Number of packages : ");
        combien.setBounds(10, 250, 800, 50);
        window.add(combien);
        JTextField nombre = new JTextField (20) ;
        nombre . setBounds (100 , 300 , 130 , 25) ;
        window . add ( nombre ) ;

        JLabel maxPackages = new JLabel("Total of packages available : " + maximumPackages );
        maxPackages.setBounds(280, 250, 800, 50);
        window.add(maxPackages);

        JLabel demandes = new JLabel("Please enter the dimensions of your(s) package(s)");
        demandes.setBounds(130, 330, 800, 50);
        window.add(demandes);

        // input height
        JLabel inputHeight = new JLabel ( "Height: " );
        inputHeight . setBounds (40 , 380 , 150 , 25) ;
        window . add ( inputHeight ) ;
        JTextField dimensionsHeight = new JTextField (20) ;
        dimensionsHeight . setBounds (100 , 380 , 130 , 25) ;
        window . add ( dimensionsHeight ) ;
        JLabel unitHeight = new JLabel ( " cm" );
        unitHeight . setBounds (230 , 380 , 150 , 25) ;
        window . add ( unitHeight ) ;

        JButton validateHeight = new JButton("Confirm");
        validateHeight.setBounds(330, 380, 150, 25);
        window.add(validateHeight);

        validateHeight.addActionListener(e -> {
            try {
                double packageHeight = Double.parseDouble(dimensionsHeight.getText().trim());
                if (packageHeight > 0 && packageHeight <= maxHeight) {
                    JOptionPane.showMessageDialog(window, "Valid height: " + packageHeight + " cm.");
                } else {
                    JOptionPane.showMessageDialog(window, "Height must be between 0 and " + maxHeight + " cm.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(window, "Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // input width
        JLabel inputWidth = new JLabel ( "Width: " );
        inputWidth . setBounds (40 , 420 , 150 , 25) ;
        window . add ( inputWidth ) ;
        JTextField dimensionsWidth = new JTextField (20) ;
        dimensionsWidth . setBounds (100 , 420 , 130 , 25) ;
        window . add ( dimensionsWidth ) ;
        JLabel unitWidth = new JLabel ( " cm" );
        unitWidth . setBounds (230 , 420 , 150 , 25) ;
        window . add ( unitWidth ) ;

        JButton validateWidth = new JButton("Confirm");
        validateWidth.setBounds(330, 420, 150, 25);
        window.add(validateWidth);

        validateWidth.addActionListener(e -> {
            try {
                double packageWidth = Double.parseDouble(dimensionsWidth.getText().trim());
                if (packageWidth > 0 && packageWidth <= maxWidth) {
                    JOptionPane.showMessageDialog(window, "Valid width: " + packageWidth + " cm.");
                } else {
                    JOptionPane.showMessageDialog(window, "Width must be between 0 and " + maxWidth + " cm.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(window, "Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // input length
        JLabel inputLength = new JLabel ( "Length: " );
        inputLength . setBounds (40 , 460 , 150 , 25) ;
        window . add ( inputLength ) ;
        JTextField dimensionsLength = new JTextField (20) ;
        dimensionsLength . setBounds (100 , 460 , 130 , 25) ;
        window . add ( dimensionsLength ) ;
        JLabel unitLength = new JLabel ( " cm" );
        unitLength . setBounds (230 , 460 , 150 , 25) ;
        window . add ( unitLength ) ;

        JButton validateLength = new JButton("Confirm");
        validateLength.setBounds(330, 460, 150, 25);
        window.add(validateLength);

        validateLength.addActionListener(e -> {
            try {
                double packageLength = Double.parseDouble(dimensionsLength.getText().trim());
                if (packageLength > 0 && packageLength <= maxLength) {
                    JOptionPane.showMessageDialog(window, "Valid length: " + packageLength + " cm.");
                } else {
                    JOptionPane.showMessageDialog(window, "Length must be between 0 and " + maxLength + " cm.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(window, "Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // input weight
        JLabel inputWeight = new JLabel ( "Weight: " );
        inputWeight . setBounds (40 , 500 , 150 , 25) ;
        window . add ( inputWeight ) ;
        JTextField dimensionsWeight = new JTextField (20) ;
        dimensionsWeight . setBounds (100 , 500 , 130 , 25) ;
        window . add ( dimensionsWeight ) ;
        JLabel unitWeight = new JLabel ( " kg" );
        unitWeight . setBounds (230 , 500 , 150 , 25) ;
        window . add ( unitWeight ) ;

        JButton validateWeight = new JButton("Confirm");
        validateWeight.setBounds(330, 500, 150, 25);
        window.add(validateWeight);

        validateWeight.addActionListener(e -> {
            try {
                double packageWeight = Double.parseDouble(dimensionsWeight.getText().trim());
                if (packageWeight > 0 && packageWeight <= maxWeight) {
                    JOptionPane.showMessageDialog(window, "Valid weight: " + packageWeight + " kg.");
                } else {
                    JOptionPane.showMessageDialog(window, "Weight must be between 0 and " + maxWeight + " kg.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(window, "Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        JButton goBack = new JButton("Previous");
        goBack.setBounds(25, 925, 150, 25);
        window.add(goBack);

        goBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.dispose(); // Ferme la fenêtre actuelle
            }
        });

        JButton goLetters = new JButton("Letters");
        goLetters.setBounds(420, 925, 150, 25);
        window.add(goLetters);

        goLetters.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.dispose();
                lettersToSend(100, modelLetters, 200);
            }
        });

        // les destinations : locale ou internationale
        JLabel destinations = new JLabel("DESTINATIONS : ");
        destinations.setBounds(230, 580, 800, 50);
        window.add(destinations);

        //local
        JCheckBox checkDestinationsLocal = new JCheckBox("Local");
        checkDestinationsLocal.setBounds(25,620,200,50);
        window.add(checkDestinationsLocal);

        //international
        JCheckBox checkDestinationsInter = new JCheckBox("International");
        checkDestinationsInter.setBounds(25,660,200,50);
        window.add(checkDestinationsInter);


        // Bouton pour calculer le prix
        JButton calculatePrice = new JButton("Calculate Price");
        calculatePrice.setBounds(100, 750, 150, 25);
        window.add(calculatePrice);

        // Label pour afficher le prix
        JLabel priceLabel = new JLabel("Price: ");
        priceLabel.setBounds(300, 750, 200, 25);
        window.add(priceLabel);

        // avoir le prix
        calculatePrice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Récupérer le poids saisi
                double weight = Double.parseDouble(dimensionsWeight.getText());
                // Récupérer le nombre de paquets saisi
                int packageCount = Integer.parseInt(nombre.getText());

                // Vérifier les destinations et calculer le prix
                double priceLocal = 2.0; // 2 euros par kg pour local
                double priceInter = 3.0; // 3 euros par kg pour international
                double finalPrice = 0;

                // si je prends local en checkbox et non international, alors
                if (checkDestinationsLocal.isSelected() && !checkDestinationsInter.isSelected()) {
                    finalPrice = weight * priceLocal * packageCount;

                    // si je prends international en checkbox et non local, alors
                } else if (checkDestinationsInter.isSelected() && !checkDestinationsLocal.isSelected()) {
                    finalPrice = weight * priceInter * packageCount;
                } else {
                    priceLabel.setText("Select a destination ");
                    return;
                }

                // Afficher le prix calculé
                priceLabel.setText("Price: " + finalPrice + " €");
            }
        });


        // limite de 50 packages en 1 jour

        JButton send = new JButton("Send");
        send.setBounds(25, 875, 150, 25);
        window.add(send);

        send.addActionListener(e -> {
            try {
                double packageHeight = Double.parseDouble(dimensionsHeight.getText().trim());
                double packageWidth = Double.parseDouble(dimensionsWidth.getText().trim());
                double packageLength = Double.parseDouble(dimensionsLength.getText().trim());
                double packageWeight = Double.parseDouble(dimensionsWeight.getText().trim());
                int packageCount = Integer.parseInt(nombre.getText().trim());
                String destination = "Unknown"; // Valeur par défaut
                double price = 0.0;  // Valeur par défaut


                if (checkDestinationsLocal.isSelected()) {
                    destination = "Local";
                    price = packageWeight * 2 * packageCount;
                } else if (checkDestinationsInter.isSelected()) {
                    destination = "International";
                    price = packageWeight * 3 * packageCount;
                } else {
                    destination = "Unknown"; // Si aucune des cases n'est cochée, définir une valeur par défaut ou afficher une erreur
                }


                // Affichage de débogage des valeurs lues
                System.out.println("Adding package: " + packageHeight + " cm, " + packageWidth + " cm, " + packageLength + " cm, " + packageWeight + " kg, " + packageCount + " packages, " + destination + ", " + price + " €");

                // Ajout du paquet à la liste des paquets envoyés
                sentPackages.add(new PackageData(packageHeight, packageWidth, packageLength, packageWeight, packageCount, destination, price));

                // Ajouter les données au modèle
                modelPackages.addRow(new Object[]{
                        "Package", packageHeight + " cm", packageWidth + " cm", packageLength + " cm", packageWeight + " kg", packageCount, destination, price + " €"
                });

                JOptionPane.showMessageDialog(window, "Package sent successfully!");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(window, "Please fill out all fields correctly.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        window.setVisible(true);
    }

    public static void lettersToSend (int maxWeightLetters, DefaultTableModel modelLetters, int maximumLetters) {
        // Creating the frame
        JFrame window = new JFrame("Letters page");
        window.setBounds(500,0,600,1000);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(null);
        window.setResizable(false);

        window.getContentPane().setBackground(Color.LIGHT_GRAY);

        // text for features to warn people
        JLabel cl = new JLabel("MAXIMUM DIMENSIONS OF LETTERS : " );
        cl.setBounds(150, 40, 800, 50);
        window.add(cl);

        JLabel mWeight = new JLabel("Maximum weight : " + maxWeightLetters + " g");
        mWeight.setBounds(10, 100, 800, 50);
        window.add(mWeight);

        JLabel demandes = new JLabel("Please enter the dimensions of your(s) letter(s)");
        demandes.setBounds(130, 330, 800, 50);
        window.add(demandes);

        JLabel combien = new JLabel("Number of letters : ");
        combien.setBounds(10, 250, 800, 50);
        window.add(combien);
        JTextField nombre = new JTextField (20) ;
        nombre . setBounds (100 , 300 , 130 , 25) ;
        window . add ( nombre ) ;

        JLabel maxLetters = new JLabel("Total of letters available : " + maximumLetters );
        maxLetters.setBounds(280, 250, 800, 50);
        window.add(maxLetters);

        // input weight
        JLabel inputWeight = new JLabel ( "Weight: " );
        inputWeight . setBounds (40 , 500 , 150 , 25) ;
        window . add ( inputWeight ) ;
        JTextField dimensionsWeight = new JTextField (20) ;
        dimensionsWeight . setBounds (100 , 500 , 130 , 25) ;
        window . add ( dimensionsWeight ) ;
        JLabel unitWeight = new JLabel ( " g" );
        unitWeight . setBounds (230 , 500 , 150 , 25) ;
        window . add ( unitWeight ) ;

        JButton validateWeight = new JButton("Confirm");
        validateWeight.setBounds(300, 500, 150, 25);
        window.add(validateWeight);

        validateWeight.addActionListener(e -> {
            try {
                double poidsLettre = Double.parseDouble(dimensionsWeight.getText().trim());
                if (poidsLettre > 0 && poidsLettre <= maxWeightLetters) {
                    JOptionPane.showMessageDialog(window, "Valid weight: " + poidsLettre + " g.");
                } else {
                    JOptionPane.showMessageDialog(window, "Weight must be between 0 and " + maxWeightLetters + " g.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(window, "Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // les destinations : locale ou internationale
        JLabel destinations = new JLabel("DESTINATIONS : ");
        destinations.setBounds(230, 580, 800, 50);
        window.add(destinations);

        //local
        JCheckBox checkDestinationsLocal = new JCheckBox("Local");
        checkDestinationsLocal.setBounds(25,620,200,50);
        window.add(checkDestinationsLocal);

        //international
        JCheckBox checkDestinationsInter = new JCheckBox("International");
        checkDestinationsInter.setBounds(25,660,200,50);
        window.add(checkDestinationsInter);

        // Bouton pour calculer le prix
        JButton calculatePrice = new JButton("Calculate Price");
        calculatePrice.setBounds(100, 750, 150, 25);
        window.add(calculatePrice);

        // Label pour afficher le prix
        JLabel priceLabel = new JLabel("Price: ");
        priceLabel.setBounds(300, 750, 200, 25);
        window.add(priceLabel);

        // avoir le prix
        calculatePrice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Récupérer le nombre de paquets saisi
                int packageCount = Integer.parseInt(nombre.getText());

                // Vérifier les destinations et calculer le prix
                double priceLocal = 0.5; // 0.5 euro par lettre pour local
                double priceInter = 1.0; // 1 euro par lettre pour international
                double finalPrice = 0;

                // si je prends local en checkbox et non international, alors
                if (checkDestinationsLocal.isSelected() && !checkDestinationsInter.isSelected()) {
                    finalPrice = priceLocal * packageCount;

                    // si je prends international en checkbox et non local, alors
                } else if (checkDestinationsInter.isSelected() && !checkDestinationsLocal.isSelected()) {
                    finalPrice = priceInter * packageCount;
                } else {
                    priceLabel.setText("Select a destination ");
                    return;
                }

                // Afficher le prix calculé
                priceLabel.setText("Price: " + finalPrice + " €");
            }
        });

        JButton goBack = new JButton("Previous");
        goBack.setBounds(25, 925, 150, 25);
        window.add(goBack);

        goBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.dispose(); // Ferme la fenêtre actuelle
            }
        });

        JButton send = new JButton("Send");
        send.setBounds(25, 875, 150, 25);
        window.add(send);

        send.addActionListener(e -> {
            try {
                double letterWeight = Double.parseDouble(dimensionsWeight.getText().trim());
                int letterCount = Integer.parseInt(nombre.getText().trim());
                String letterdestination = "Unknown";
                double letterprice = 0.0;

                if (checkDestinationsLocal.isSelected()) {
                    letterdestination = "Local";
                    letterprice = 0.5 * letterCount;
                } else if (checkDestinationsInter.isSelected()) {
                    letterdestination = "International";
                    letterprice = 1 * letterCount;
                } else {
                    letterdestination = "Unknown"; // Si aucune des cases n'est cochée, définir une valeur par défaut ou afficher une erreur
                }


                // Affichage de débogage des valeurs lues
                System.out.println("Adding letter: " + letterWeight + " g, " + letterCount + " letters, " + letterdestination + ", " + letterprice + " €");

                // Ajout du paquet à la liste des paquets envoyés
                sentLetters.add(new LettersData(letterWeight, letterCount, letterdestination, letterprice));

                // Ajouter les données au modèle
                modelLetters.addRow(new Object[]{
                        letterWeight + " g", letterCount, letterdestination, letterprice + " €"
                });

                JOptionPane.showMessageDialog(window, "Letters sent successfully!");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(window, "Please fill out all fields correctly.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        JButton goPackages = new JButton("Packages");
        goPackages.setBounds(420, 925, 150, 25);
        window.add(goPackages);

        goPackages.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.dispose();
                packagesToSend(100, 100, 100, 100, modelPackages, 50);
            }
        });

        window.setVisible(true);
    }

    public static void menu () {
        // Creating the frame
        JFrame window = new JFrame("Selection");
        window.setBounds(500,0,600,1000);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(null);
        window.setResizable(false);

        window.getContentPane().setBackground(Color.LIGHT_GRAY);

        // initial text
        JLabel cl = new JLabel("Welcome to the post office, need to send some packages or letters ?");
        cl.setBounds(10, 40, 800, 50);
        window.add(cl);

        // Selection of the packet
        JLabel choice = new JLabel("Select the one you want to send");
        choice.setBounds(10, 80, 800, 50);
        window.add(choice);

        // button of packages
        JButton package_post = new JButton ( " Packages " ) ;
        package_post . setBounds (50,300,500,50) ;
        window . add ( package_post ) ;

        // event of packages button
        package_post.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Appeler la méthode de détection du visage lorsque le bouton est cliqué
                DefaultTableModel modelLetters = new DefaultTableModel();
                packagesToSend(100, 100, 100, 100, modelPackages, 50);
            }
        });

        // button of letters
        JButton letter = new JButton ( " Letters " ) ;
        letter . setBounds (50,450,500,50) ;
        window . add ( letter ) ;

        // event of letters button
        letter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Appeler la méthode de détection du visage lorsque le bouton est cliqué
                lettersToSend(100, modelLetters, 200);
            }
        });

        JButton goBack = new JButton("Previous");
        goBack.setBounds(25, 925, 150, 25);
        window.add(goBack);

        goBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.dispose(); // Ferme la fenêtre actuelle
            }
        });

        window.setVisible(true);
    }

    public static void recap () {
        // Creating the frame
        JFrame window = new JFrame("Summarize of the day");
        window.setBounds(50,0,1800,1000);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(null);
        window.setResizable(false);

        window.getContentPane().setBackground(Color.LIGHT_GRAY);

        // Création de la JTable pour afficher les packages
        JTable table = new JTable(modelPackages);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 50, 800, 900);
        window.add(scrollPane);

        // Vider le modèle pour éviter les doublons
        modelPackages.setRowCount(0);

        // Si des paquets ont été envoyés, ajoutez-les au modèle de table
        for (PackageData pkg : sentPackages) {
            modelPackages.addRow(new Object[]{
                    "Package", pkg.height + " cm", pkg.width + " cm", pkg.length + " cm", pkg.weight + " kg", pkg.quantity, pkg.destination, pkg.price + " €"
            });
        }

        // Création de la JTable pour afficher les lettres
        JTable tableLetter = new JTable(modelLetters);
        JScrollPane scrollPaneLetter = new JScrollPane(tableLetter);
        scrollPaneLetter.setBounds(900, 50, 700, 900);
        window.add(scrollPaneLetter);

        // Vider le modèle pour éviter les doublons
        modelLetters.setRowCount(0);

        // Si des lettres ont été envoyées, ajoutez-les au modèle de table
        for (LettersData ltr : sentLetters) {
            modelLetters.addRow(new Object[]{
                    "Letter", ltr.weight + " g", ltr.quantity, ltr.destination, ltr.price + " €"
            });
        }

        window.setVisible(true);
    }

    public static void main(String[] args) {
        // Creating the frame
        JFrame window = new JFrame("Post Office");
        window.setBounds(500,0,600,1000);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(null);
        window.setResizable(false);

        window.getContentPane().setBackground(Color.LIGHT_GRAY);

        // button of main menu
        JButton newCustomer = new JButton ( " New customer " ) ;
        newCustomer . setBounds (50,300,500,50) ;
        window . add ( newCustomer ) ;

        // event of packages button
        newCustomer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Appeler la méthode de détection du visage lorsque le bouton est cliqué
                menu();
            }
        });

        // button of system --> end of the day
        JButton end = new JButton ( " End of the day " ) ;
        end . setBounds (50,450,500,50) ;
        window . add ( end ) ;

        // event of end day
        end.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.dispose();
                //System.out.println("Rows in modelPackages: " + modelPackages.getRowCount());
                recap();
            }
        });

        // Configuration pour le tableau package
        modelPackages.addColumn("Type");
        modelPackages.addColumn("Height");
        modelPackages.addColumn("Width");
        modelPackages.addColumn("Length");
        modelPackages.addColumn("Weight");
        modelPackages.addColumn("Count");
        modelPackages.addColumn("Destination");
        modelPackages.addColumn("Price");

        // Configuration pour le tableau letters
        modelLetters.addColumn("Type");
        modelLetters.addColumn("Weight");
        modelLetters.addColumn("Count");
        modelLetters.addColumn("Destination");
        modelLetters.addColumn("Price");

        window.setVisible(true);
    }
}