package Controller;

import Model.LibraryModel;

public class SaveLibraryCommand implements LibraryCommand {
    private LibraryModel libraryModel;
    private String fieldOfInterest;
    private String libraryName;
    private String libraryLocation;

    public SaveLibraryCommand(LibraryModel libraryModel, String fieldOfInterest, String libraryName,
            String libraryLocation) {
        this.libraryModel = libraryModel;
        this.fieldOfInterest = fieldOfInterest;
        this.libraryName = libraryName;
        this.libraryLocation = libraryLocation;
    } // savelibrary

    @Override
    public void execute() {
        libraryModel.setFieldOfInterest(fieldOfInterest);
        libraryModel.setLibraryName(libraryName);
        libraryModel.setLibraryLocation(libraryLocation);

        System.out.println("Library saved: " + libraryName);
    }
}
