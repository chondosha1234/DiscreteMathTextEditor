package gui;

/*
 * Dialog listener interface helps to connect the symbolSelection dialog class to the 
 * numpad buttons for selecting and changing the symbols 
 */
public interface DialogListener {

    void onDialogClose(String primary, String secondary);
}
