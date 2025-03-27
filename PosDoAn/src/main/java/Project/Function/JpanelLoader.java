/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Project.Function;

import javax.swing.JPanel;
import java.awt.*;

public class JpanelLoader {

    // đưa trang Panel mong muốn vào panelLoaderPanel
   public void load(JPanel Main,JPanel setPanel){
       if (Main == null || setPanel == null) {
           throw new IllegalArgumentException("Panels cannot be null");
       }

       Main.removeAll();
       Main.setLayout(new BorderLayout());
       Main.add(setPanel, BorderLayout.CENTER);

       Main.revalidate();
       Main.repaint();
    }

}
