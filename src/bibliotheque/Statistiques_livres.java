package bibliotheque;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Statistiques_livres {
	
	public Statistiques_livres() {
			
		JFrame frame = new JFrame("Statistiques sur les livres les plus empruntés");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        model.addColumn("Titre");
        model.addColumn("Auteur");
        model.addColumn("Nombre d'Emprunts");

        try {
            List<RapportStatDTO> listeRapportStatDTO = Emprunt.getRapportLivre();
            for (RapportStatDTO object : listeRapportStatDTO) {
                model.addRow(new Object[]{object.getChaine1(),object.getChaine2(),object.getNbEmp()});
            }
        } catch (MyException ex) {
            JOptionPane.showMessageDialog(frame, ex.getMessage());
        }
        
        
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
       
        JButton retour = new JButton("Retour a L'Accueil");        
        retour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new Biblio_accueil();

            }
        });
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(retour);

        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        frame.setSize(800, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

