package MainTaxiApp.Classes;

import java.io.*;

public class TextHandler {
    private final String USERS_FILE_PATH = "users.csv";
    private final String TAXIS_FILE_PATH = "Taxis.csv";

    public String getUSERS_FILE_PATH() {
        return USERS_FILE_PATH;
    }

    public String getTAXIS_FILE_PATH() {
        return TAXIS_FILE_PATH;
    }



    public LinkedList<User> readUsersAndPasswords(String file) {
        LinkedList<User> usersAndPasswords = new LinkedList<>();
        try (BufferedReader resultReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = resultReader.readLine()) != null) {
                String[] values = line.split(",");
                usersAndPasswords.insert(new User(values[0], values[1]));
            }
        } catch (IOException e) {
            System.out.println("Cant find or read users.csv file");
            e.printStackTrace();
        }
        return usersAndPasswords;
    }
    public void writeInNewUser(String username, String password, String file){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));

            String[] data = { username, password };
            String dataLine = String.join(",", data);
            writer.write(dataLine);
            writer.newLine();

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
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
            System.out.println("Cant find or read Taxis.csv file");
            e.printStackTrace();
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
                System.out.println("Error writing to Taxis.csv file");
                e.printStackTrace();
            }
        }
        }



