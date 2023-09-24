package com.fapethedev.ogine.view.component.label;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.border.Border;

import com.fapethedev.ogine.view.component.border.TextBubbleBorder;

/**
 * @author FATIGBA Abiola Pierre-Edy
 *
 */
public final class Message extends JLabel
{
    public static final String DEFAULT_TITLE_MSG = "Message";
    public static final String ERROR_TITLE_MSG = "Erreur";
    public static final String EXIT_TITLE_MSG = "Fermeture de l'application";
    public static final String CONFIRM_TITLE = "Voulez-vous continuer ?";
    public static final String LOGOUT_TITLE_MSG = "Voulez-vous vous déconnecter ?";

    public static final String CON_TITLE_MSG = "PAGE DE CONNEXION";
    public static final String DASH_TITLE = "TABLEAU DE BORD";	
    public static final String USERNAME_TITLE = "NOM D'UTILISATEUR";
    public static final String PASSWORD_TITLE = "MOT DE PASSE";
    public static final String REGISTER_FORM_TITLE = "FORMULAIRE D'INSCRIPTION ETUDIANT";
    public static final String REREGISTER_FORM_TITLE = "FORMULAIRE DE Ré-INSCRIPTION ETUDIANT".toUpperCase();
    public static final String STUDENT_REGISTER_FORM_TITLE = "FORMULAIRE D'ENREGISTREMENT ETUDIANT";
    public static final String DEFAULT_PANE_FORM_TITLE = "BIENVENUE DANS STRyG";
    public static final String DATA_PANE_FORM_TITLE = "LISTE DES ETUDIANTS";
    public static final String OPTION_PANE_FORM_TITLE = "PARAMETRES GENERAUX";

    public static final String EXIT_INFO_MSG = "VOULEZ-VOUS QUITTEZ L'APPLICATION ?";
    public static final String CONFIRM_INFO_MSG ="VOUS ÊTES SUR LE POINT D'EFFECTUER UN ENREGISTREMENT !";
    public static final String CONFIRM_UPDATE_INFO_MSG = "VOUS ÊTES SUR LE POINT D'EFFECTUER UNE MISA A JOUR !";
    public static final String ASK_INSCR_INFO_MSG = "Voulez-Vous procéder à son inscription ?".toUpperCase();
    public static final String ASK_INSCR_UPD_INFO_MSG = "Voulez-Vous procéder à la mise à jour de son inscription ?".toUpperCase();
    public static final String CANCEL_INFO_MSG = "VOULEZ-VOUS ANNULER L'OPERATION EN COURS ?";
    public static final String ASK_CHECK_DATA_MSG = "VOULEZ-VOUS CONSULTER LA LISTE DES ETUDIANTS ?";
    public static final String CONFIRM_INSCR_INFO_MSG = "VOUS ÊTES SUR LE POINT D'EFFECTUER UNE INSCRIPTION";
    public static final String RESET_FORM_MSG = "VOULEZ-ËTES SUR LE POINT DE RéINITIALISER LE FORMULAIRE".toUpperCase();
    public static final String RESET_SUCCES_MSG = "RéINITIALISATION TERMINER".toUpperCase();

    public static final String ALL_FIELD_MISSING_MSG = "VEUILLEZ REMPLIR TOUS LES CHAMPS !";
    public static final String USERNAME_MISSING_MSG = "VEUILLEZ SAISIR UN NOM D'UTILISATEUR !";
    public static final String PASSWORD_MISSING_MSG = "VEUILLEZ SAISIR UN MOT DE PASSE !";
    public static final String LOGOUT_INFO_MSG = "TOUT TRAVAIL NON ENREGISTRER SERA PERDU !";

    public static final String USERNAME_ERROR_MSG = "NOM D'UTILISATEUR INCORRECT !";
    public static final String PASSWORD_ERROR_MSG = "MOT DE PASSE INCORRECT !";

    public static final String WELCOME_GUEST_MSG = "BIENVENUE CHER INVITé !".toUpperCase();
    
    public static final String AUTENTIFICATION_SUCCESS_MSG = "AUTHENTIFICATION REUSSI !";
    public static final String REGISTRATION_SUCCESS_MSG = "ENREGISTREMENT EFFUCTUER AVEC SUCCES";
    public static final String UPDATE_SUCCESS_MSG = "MISE A JOUR EFFUCTUER AVEC SUCCES";
    public static final String UPDATE_COMPLETE_MSG = "MISE A JOUR TERMINER";

    public static final String EMPTY_FIELD_MSG = "VEUILLEZ REMPLIR ICI !";

    public static final String INFO_ETUDIANTS = "INFORMATIONS SUR L'ETUDIANT";
    public static final String INFO_INSCRIPTIONS = "INFORMATIONS SUR L'INSCRIPTION";
    public static final String INFO_REINSCRIPTIONS = "INFORMATIONS SUR LA REINSCRIPTION";
    public static final String INFO_PERSONNELS = "INFORMATIONS PERSONNELLES";
    public static final String INFO_SUPPLEMENTAIRE = "INFORMATIONS SUPPLEMENTAIRES";
    public static final String INFO_PARENTS = "INFORMATIONS SUR LES PARENTS";
    public static final String INFO_AUTRES = "AUTRES INFORMATIONS";

    public static final String USERNAME_TAG ="Nom d'utilisateur";
    public static final String PASSWORD_TAG ="Mot de passe";
    public static final String USERROLE_TAG = "Rôle de l'utilisateur";
    public static final String SHOW_TAG = "Afficher le mot de passe";
    public static final String EXIT_TAG = "Quittez";
    public static final String LOGIN_TAG = "Se Connecter";
    public static final String PIC_TAG = "Ajouter une photo";
    public static final String PIC_TAG2 = "Photo de l'Etudiant";
    public static final String OK_TAG = "Confirmer";
    public static final String RESET_TAG = "Réinitialiser";
    public static final String CANCEL_TAG = "Annuler";
    public static final String UPDATE_TAG = "Modifier les informations relatives de l'Etudiant";
    public static final String PREVIEW_TAG = "Visualiser les informations relatives de l'Etudiant";
    public static final String DELETE_TAG = "Supprimer les inforations relatives de l'Etudiants";

    public static final String ENREGIS_TAG = "ENREGISTREMENT";
    public static final String LISTE_TAG = "LISTES DES ETUDIANTS";
    public static final String ACTION_TAG = "ACTIONS";
    public static final String OPTION_TAG = "OPTIONS";
    public static final String INSCRIS_TAG = "INSCRIPTIONS";
    public static final String LOGOUT_TAG = "DECONNEXION";

    public static final String LAST_NAME = "Nom de Famille de l'Etudiant";
    public static final String FIRST_NAME = "Prénoms de l'Etudiant";
    public static final String BIRTH_TAG = "Date de Naissance de l'Etudiant";
    public static final String CNI_TAG = "N° Carte d'Identité de l'Etudiant";
    public static final String BLOOD_TAG = "Sélectionner le groupe sanguin"; //"Groupe Sanguin de l'Etudiant";
    public static final String SEX_TAG = "Sexe de l'Etudiant";
    public static final String FATH_NAME = "Nom du Père";
    public static final String FATH_NUM = "Ex : +(228) XX-XX-XX-XX";
    public static final String FATH_FUNCT = "Fonction du Père";
    public static final String MOTH_NAME = "Nom de la Mère";
    public static final String MOTH_NUM = "Ex : +(228) XX-XX-XX-XX";
    public static final String MOTH_FUNCT = "Fonction de la Mère";
    public static final String TUTO_NAME = "Nom du Tuteur";
    public static final String TUTO_NUM = "Ex : +(228) XX-XX-XX-XX";
    public static final String TUTO_FUNCT = "Fonction du Tuteur";
    public static final String PHONE_TAG = "Ex : +(228) XX-XX-XX-XX";
    public static final String ADDR_TAG = "Adresse de l'Etudiant";
    public static final String FAITH_TAG = "Religion de l'Etudiant";
    public static final String YEAR_TAG = "Année d'inscription";
    public static final String MATRICULE_TAG = "Matricule de l'Etudiant";
    public static final String INSTITUT_TAG = "Institut de l'Etudiant";
    public static final String LEVEL_TAG = "Niveau de l'Etudiant";
    public static final String SPECIALITY_TAG = "Spécialité de l'Etudiant";

    public static final String FAILED_UPDATE_MSG = "Echec de la modification";
    public static final String FAILED_INSERT_MSG = "Echec de l'enregistrement";
    public static final String FAILED_DELETE_MSG = "Echec de la suppression";
    public static final String FAILED_SELECT_MSG = "Echec de la sélection";
    public static final String SORTER_TITLE = "FILTRER :";
    public static final String ALL_OPTION_MISSING_MSG = "VEUILLEZ CHOISIR TOUTES LES OPTIONS";
    public static final String YEAR_OPTION_TIP = "Rechercher les étudiants selon l'année";
    public static final String MATRI_OPTION_TIP = "Rechercher les étudiants selon le matricule";
    public static final String NAME_OPTION_TIP = "Rechercher les étudiants selon le nom/prénom";
    public static final String INSTI_OPTION_TIP = "Rechercher les étudiants selon l'institut";
    public static final String LEVEL_OPTION_TIP = "Rechercher les étudiants selon le niveau";
    public static final String SPEC_OPTION_TIP = "Rechercher les étudiants selon la spécialité";
    public static final String REPORT_TAG = "MENU IMPRESSION";
    public static final String IS_EXISTS_MSG = "L'ETUDIANT EXISTE DEJA !";
    public static final String JASPER_PANE_FORM_TITLE = "MENU IMPRESSION";
    public static final String CONFIRM_DELETE_INFO_MSG = "VOUS ÊTES SUR LE POINT DE SUPPRIMER UN ETUDIANT";
    public static final String DELETE_SUCCES_MSG = "ETUDIANT SUPPRIMER AVEC SUCCES";
    public static final String CONFIRM_STUDENT_REPORT_MSG = "VOULEZ-VOUS IMPRIMER LA LISTE DES ETUDIANTS DEJA ENREGISTRER ?";
    public static final String CONFIRM_REGISTER_REPORT_MSG = "VOULEZ-VOUS IMPRIMER LA LISTE DES ETUDIANTS DEJA INSCRITS ?";
    public static final String CONFIRM_SCHOOL_STUDENT_REPORT_MSG = "VOULEZ-VOUS IMPRIMER LA LISTE DES ETUDIANTS?";
	public static final String STUDENT_REGISTER_CHART_TITLE = "SITUATION GéNERALE".toUpperCase();
	public static final String NEW_PAPERS_TAG = "Créér une nouvelle fiche".toUpperCase();
	public static final String SAVE_INFO_MSG = "VOULEZ-VOUS SAUVERGARDER L'IMAGE";
	public static final String SAVE_TITLE = "ENREGISTRER";
	public static final String DO_You_WANT_TO_LOG_AS_GUEST = "ÊTES VOUS SURE DE VOULOIR VOUS CONNECTEZ EN TANT QU'INVITé ?".toUpperCase();
	
    private final Border border;
    private final Color borderColor;
    private final Font contentFont;

    public Message(String message)
    {
        super(message);
        borderColor = Color.LIGHT_GRAY;
        contentFont = new Font("Times New Roman", Font.BOLD, 12);
        border = new TextBubbleBorder(borderColor, 2, 15, 8);
        this.setFont(contentFont);
        this.setBorder(border);
    }
}
