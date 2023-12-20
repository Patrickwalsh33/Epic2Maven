package MainTaxiApp.Classes;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TextHandler {

    public String getUSERS_FILE_PATH() {
        return "users.csv";
    }

    public String getTAXIS_FILE_PATH() {
        return "Taxis.csv";
    }
    private static final Logger logger = Logger.getLogger(TextHandler.class.getName());



    public LinkedList<User> readUsersAndPasswords(String file) {
        LinkedList<User> usersAndPasswords = new LinkedList<>();
        try (BufferedReader resultReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = resultReader.readLine()) != null) {
                String[] values = line.split(",");
                usersAndPasswords.insert(new User(values[0], values[1]));
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error reading users.csv file", e);
        }
        return usersAndPasswords;
    }
    public void writeInNewUser(User user, String file){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));

            String[] data = { user.getUsername(), user.getPassword() };
            String dataLine = String.join(",", data);
            writer.write(dataLine);
            writer.newLine();

            writer.close();

        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error writing to User.csv file", e);
        }


    }
    public LinkedList<Taxi> readTaxiData(String file) {
        LinkedList<Taxi> taxis = new LinkedList<>();
        try (BufferedReader resultReader = new BufferedReader(new FileReader(file))) {
            String line;
            taxis.moveToFirst();
            while ((line = resultReader.readLine()) != null) {
                String[] values = line.split(",");
                taxis.insert( new Taxi(values[0],values[1],Integer.parseInt(values[2]),values[3],values[4]));
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error reading to Taxi.csv file", e);
        }
        return taxis;
    }
        public void writeInNewTaxiRating(Taxi subject, int newRating, String file) {
            LinkedList<Taxi> updatedTaxis = readTaxiData(file);

            updatedTaxis.moveToFirst();
            for(int i=0; i<updatedTaxis.size();i++) {
                if (subject.getName().equals(updatedTaxis.getData().getName())) {
                    updatedTaxis.getData().setRating(newRating);
                    break;
                } else {
                    updatedTaxis.moveToNext();
                }
            }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                updatedTaxis.moveToFirst();
                for(int i=0; i<updatedTaxis.size();i++) {
                   Taxi current= updatedTaxis.getData();
                   String line = current.getRegistration()+","+current.getName()+","+current.getRating()+","+current.getBrand()+","+current.getSize();
                    writer.write(line);
                    writer.newLine();
                    updatedTaxis.moveToNext();
                }
            } catch (IOException e) {
                logger.log(Level.SEVERE, "Error writing the rating into the Taxi.csv file", e);
            }
        }
        }



