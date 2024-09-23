id    name         age  email
1     John Doe     30   johndoe@example.com
2     Jane Smith   25   janesmith@example.com


```java

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FlatFileToJsonWithSpaces {

    public static JSONArray convertFlatFileToJson(String filePath) {
        JSONArray jsonArray = new JSONArray();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            String[] headers = null;

            // Lire la première ligne pour obtenir les en-têtes de colonnes
            if ((line = br.readLine()) != null) {
                headers = line.trim().split("\\s+"); // Séparer les en-têtes par des espaces multiples
            }

            // Lire chaque ligne du fichier et convertir en JSON
            while ((line = br.readLine()) != null) {
                String[] fields = line.trim().split("\\s+"); // Séparer les champs par des espaces multiples
                JSONObject jsonObject = new JSONObject();

                for (int i = 0; i < headers.length; i++) {
                    jsonObject.put(headers[i], fields[i].trim());
                }

                jsonArray.put(jsonObject);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return jsonArray;
    }

    public static void main(String[] args) {
        String filePath = "chemin/vers/votre/fichier.txt";  // Spécifiez le chemin de votre fichier plat
        JSONArray json = convertFlatFileToJson(filePath);
        System.out.println(json.toString(4));  // Affiche le JSON formaté avec indentation
    }
}
```

```json
[
    {
        "id": "1",
        "name": "John",
        "age": "30",
        "email": "johndoe@example.com"
    },
    {
        "id": "2",
        "name": "Jane",
        "age": "25",
        "email": "janesmith@example.com"
    }
]
```

```xml
<dependency>
    <groupId>org.json</groupId>
    <artifactId>json</artifactId>
    <version>20210307</version>
</dependency>
```

