type nucleotide = A | C | G | T

let hamming_distance dna_chain_one dna_chain_two =
  match List.length dna_chain_one, List.length dna_chain_two with
  | 0, 0  -> Ok 0
  | 0, _ -> Error "left strand must not be empty"
  | _, 0 -> Error "right strand must not be empty"
  | len1, len2 when len1 <> len2 -> Error "left and right strands must be of equal length"
  | _ -> let distance = 
          List.fold_left2 (fun acc n1 n2 -> if n1 = n2 then acc else acc + 1) 0 dna_chain_one dna_chain_two
        in 
        Ok distance
  
