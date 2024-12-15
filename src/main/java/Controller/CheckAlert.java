/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author scass
 */
public interface CheckAlert {
         /**
     * @brief Mostra un avviso in caso di errori di validazione.
     * 
     * @post Viene mostrato un Alert
     * 
     */

    void showValidationAlert();
     /**
     * @brief Mostra un avviso in caso di errori di validazione.
     * 
     * @post Viene mostrato un Alert
     * 
     */

    void showDuplicateAlert();
}
